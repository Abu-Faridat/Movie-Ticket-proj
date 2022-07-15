/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.repo;

import com.movie.db.ConnectingDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EKUNSAJUOLA
 */
public class AdminRepo  {
    
    public boolean login(String username, String password) throws SQLException{
        
        Connection conn = getConnection();
        
        PreparedStatement preparestatement = conn.prepareStatement(ConnectingDb.FIND_ADMIN);
        preparestatement.setString(1, username);
        preparestatement.setString(2, password);
        ResultSet rs = preparestatement.executeQuery();
        
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"....Welcome....");
            return true;
        }
        return false;
        
        
    }
    private static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movie_Ticket_System_db?createDatabaseIfNotExist=true","root","");
        
        return conn;
    }
  
}

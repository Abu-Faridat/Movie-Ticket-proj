/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.repo;

import com.movie.db.ConnectingDb;
import com.movie.enums.Theater;
import com.movie.enums.TransactionConstant;
import com.movie.model.Movies;
import com.movie.model.Transaction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author EKUNSAJUOLA
 */
public class TransactionRepo extends JFrame {

    static ConnectingDb objct = new ConnectingDb();

    static Connection connection;
    final MovieRepo movieRepo = new MovieRepo();

    /**
     * Method is used to make entry into Transaction table for the appropriate
     * transaction
     *
     * @param id : product id
     * @param number : number of product needed
     * @throws java.lang.ClassNotFoundException if the JVM tries to load a
     * particular class but does not find it in the class path
     * @throws java.sql.SQLException if there's a database access error
     */
    public Transaction buyMovieTicket(String name, int numberOfTickets, Date viewingDate) throws SQLException, ClassNotFoundException {

        Transaction trans = new Transaction();
        //find by name.....
        //change  this to name 
        Movies object = movieRepo.findByName(name);

        String theatre = object.getStreamingTheater();
        int maximumCapacity;

        String movieName = object.getMovieName();
        float fee = object.getMovieFee();

        Transaction transaction = new Transaction();
        int currentCapacity = findTransactionByTheViewDateAndThreatre(viewingDate, theatre);

        for (Theater th : Theater.values()) {
            if (th.getName().equals(theatre)) {

                maximumCapacity = th.getCapcity();

                if (maximumCapacity > currentCapacity && maximumCapacity > numberOfTickets) {
                    for (int i = 0; i < numberOfTickets; i++) {
                        trans = new Transaction(TransactionConstant.MOVIE.name(), fee, theatre, movieName, viewingDate);
                       

                        saveMovieTransaction(trans);

                    }
                    JOptionPane.showMessageDialog(this, "Successful");

                    return trans;
                } else {
                    JOptionPane.showMessageDialog(this, theatre + " filled up");

                }
            }
        }
        return null;
    }

    private void saveMovieTransaction(Transaction trans) throws SQLException {
        connection = objct.getConnection();

        PreparedStatement ps = connection.prepareStatement(ConnectingDb.INSERT_TRANSACTION_TABLE_FOR_MOVIES);

        ps.setString(1, trans.getType());
        ps.setString(2, trans.getTheatreName());
        ps.setString(3, trans.getProduct());
        ps.setFloat(4, trans.getTotal());
        ps.setDate(5, trans.getViewDate());

        ps.executeUpdate();

    }

    public static int findTransactionByTheViewDateAndThreatre(Date viewDate, String theatre) throws SQLException {
        List<Transaction> transaction = new ArrayList<>();

        connection = objct.getConnection();

        PreparedStatement ps = connection.prepareStatement(ConnectingDb.FIND_MOVIE_TRANSACTION_BY_DATE_AND_THEATRE);

        ps.setDate(1, viewDate);
        ps.setString(2, theatre);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String product_type = rs.getString("Product_Type");
            String theatreName = rs.getString("Theatre");
            String movieName = rs.getString("Product_Name");
            float fee = rs.getFloat("Total_Fee");
            Date date = rs.getDate("View_date");

            transaction.add(new Transaction(product_type, fee, theatreName, movieName, date));
        }
        return transaction.size();
    }

    public List<Transaction> getallTransaction() throws SQLException {
        List<Transaction> transactionList = new ArrayList<>();

        try {

            connection = objct.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TRANSACTION");
            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String productName = resultset.getString("Product_Name");
                String totalfee = resultset.getString("Total_Fee");
                String purchaseDate = resultset.getString("Purchase_Date");
                String viewDate = resultset.getString("View_Date");

                transactionList.add(new Transaction(productName, totalfee, purchaseDate, viewDate));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //....................connecting.......
        return transactionList;

    }

}

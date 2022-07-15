/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.db;

import com.movie.enums.Theater;
import com.movie.model.Transaction;
import com.movie.repo.AdminRepo;
import com.movie.repo.MovieRepo;
import com.movie.repo.TransactionRepo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author EKUNSAJUOLA
 */
public class ConnectingDb {

    static final MovieRepo objmovie = new MovieRepo();

    public static final String CREATE_TABLE_QUERY_ADMIN = "CREATE TABLE IF NOT EXISTS ADMIN"
            + "(Id INTEGER not NULL AUTO_INCREMENT, "
            + " Username VARCHAR(50) NOT NULL, "
            + " Password VARCHAR(255)NOT NULL, "
            + " PRIMARY KEY ( id ))";

    public static final String CREATE_TABLE_QUERY_MOVIES = "CREATE TABLE IF NOT EXISTS  MOVIES"
            + "(Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,"
            + "Movie_Name VARCHAR (50) NOT NULL UNIQUE,"
            + "Movie_Info VARCHAR (225) NOT NULL,"
            + "Start_Time Time,"
            + "End_Time Time,"
            + "Streaming_theatre VARCHAR (50),"
            + "Viewing_Fee DOUBLE (8,2) NOT NULL)";

    public static final String INSERT_INTO_MOVIE_TABLE = "INSERT into Movies"
            + "(Movie_Name, Movie_Info, Viewing_Fee, Start_time, End_time,Streaming_theatre)"
            + "VALUES (?,?,?,?,?,?)";

    public static final String FIND_MOVIE_BY_NAME = "SELECT * FROM MOVIES WHERE Movie_Name =?";

    public static final String DELETE_BY_ID = "DELETE FROM MOVIE"
            + "WHERE Id =?";

    public static final String DELETE_TABLE = "DELETE FROM ?";

    public static final String CREATE_TRANSACTION_TABLE = "CREATE TABLE IF NOT EXISTS TRANSACTION"
            + "(Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,"
            + "Product_Type VARCHAR(50) NOT NULL,"
            + "Theatre VARCHAR(50),"
            + "Product_Name VARCHAR (50) NOT NULL,"
            + "Total_Fee Double (8,2) NOT NULL,"
            + "Purchase_Date DATETIME DEFAULT CURRENT_TIMESTAMP,"
            + "View_Date DATE)";

    public static final String INSERT_TRANSACTION_TABLE_FOR_MOVIES = "INSERT INTO TRANSACTION"
            + "(Product_Type, Theatre, Product_Name, Total_Fee, View_Date)"
            + "VALUES (?,?,?,?,?)";

    public static final String FIND_MOVIE_TRANSACTION_BY_DATE_AND_THEATRE = "SELECT * FROM Transaction "
            + "WHERE DATE(view_date) =?"
            + "AND Theatre =?";

    public static final String CREATE_TABLE_ADMIN = "CREATE TABLE IF NOT EXISTS ADMIN"
            + "(Username VARCHAR(225)  NOT NULL UNIQUE ,"
            + "Password VARCHAR (225) NOT NULL)";

    public static final String FIND_ADMIN = "SELECT * FROM ADMIN WHERE Username =? AND Password =?";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movie_Ticket_System_db?createDatabaseIfNotExist=true", "root", "");

        Statement stmt = conn.createStatement();

       
//        
//        TransactionRepo obj = new TransactionRepo();
//                  List<Transaction> transactionList = obj.getallTransaction();
//                  for (Transaction transaction : transactionList) {
//                      System.out.println(transaction);
//        }
//        Date viewingDate = null;
//                  Transaction tx = obj.buyMovieTicket(FIND_ADMIN, 0, viewingDate);


//           //..........Insert Movie.........
////           
           Time sqlTime1 = Time.valueOf("19:00:00");
          
          Time sqlTime2 = Time.valueOf("20:00:00");
          
         objmovie.addMovie("Master", "Thriller | Drama", 4500.00f, sqlTime1, sqlTime2,Theater.Theatre1.getName());
          stmt.execute(INSERT_INTO_MOVIE_TABLE);
       
////           
//           //..................get all movie..........
//           
//           List<Movies> movv = objmovie.getAllMovies();
//           
//           for(Movies movies : movv) {
//               System.out.println(movies);
//         }
//           
//   
//
//       
//
//                 
////           ResultSet rs = stmt.executeQuery("select * from tabledemo");
////           
////           while (rs.next()) {
////            String name = rs.getString("FIRSTNAME");
////            System.out.println(name);
////        }
//          
//        AdminRepo obj = new AdminRepo();
//        obj.login("iu", "1234");


    }
     public static Connection getConnection() throws SQLException {
     Connection   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movie_Ticket_System_db?createDatabaseIfNotExist=true", "root", "");
        return connection;
    }
}

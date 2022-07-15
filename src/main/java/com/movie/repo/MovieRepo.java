/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.repo;

import com.movie.db.ConnectingDb;
import static com.movie.db.ConnectingDb.getConnection;
import com.movie.enums.Theater;
import com.movie.model.Movies;
import static com.movie.repo.TransactionRepo.objct;
import com.movie.service.MovieService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EKUNSAJUOLA
 */
public class MovieRepo implements MovieService {

    static ConnectingDb object = new ConnectingDb();
    static Connection connection;

    public Movies findByName(String name) {
        Movies object = null;
        try {
            connection = objct.getConnection();
            PreparedStatement ps = connection.prepareStatement(ConnectingDb.FIND_MOVIE_BY_NAME);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String movieName = rs.getString("Movie_Name");
                String movieInfo = rs.getString("Movie_Info");
                String theatre = rs.getString("Streaming_theatre");
                float movieFee = rs.getFloat("Viewing_Fee");
                Time startTime = rs.getTime("Start_time");
                Time endTime = rs.getTime("End_time");

                object = new Movies(movieName, movieInfo, theatre, movieFee, startTime, endTime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return object;
    }

    @Override
    public Movies addMovie(String movieName, String movieInfo, float movieFee, Time startTime, Time endTime, String streamingTheater) {
        Movies object = new Movies(movieName, movieInfo, streamingTheater, movieFee, startTime, endTime);

        try {
            addMovie(object);
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return object;
    }

    @Override
    public List<Movies> getAllMovies() {
        List<Movies> movieList = new ArrayList<>();

        try {

            connection = objct.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MOVIES");

            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                String movieName = resultset.getString("Movie_Name");

                String movieInfo = resultset.getString("Movie_Info");

                float movieFee = resultset.getFloat("Viewing_Fee");

                Time startTime = resultset.getTime("Start_time");

                Time endTime = resultset.getTime("End_time");

                movieList.add(new Movies(movieName, movieInfo, Theater.Theatre1.toString(), movieFee, startTime, endTime));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movieList;
    }

    private static void addMovie(Movies movie) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedstatement = connection.prepareStatement(ConnectingDb.INSERT_INTO_MOVIE_TABLE);

        preparedstatement.setString(1, movie.getMovieName());
        preparedstatement.setString(2, movie.getMovieInfo());
        preparedstatement.setFloat(3, movie.getMovieFee());
        preparedstatement.setTime(4, movie.getStartTime());
        preparedstatement.setTime(5, movie.getEndTime());
        preparedstatement.setString(6, movie.getStreamingTheater());

        preparedstatement.executeUpdate();
    }

}

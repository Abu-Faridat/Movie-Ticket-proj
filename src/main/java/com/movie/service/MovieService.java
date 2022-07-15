/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.service;

import com.movie.model.Movies;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author EKUNSAJUOLA
 */
public interface MovieService {
     
    //public Movies findByName(String movieName);
    
    public List<Movies> getAllMovies();
    
    public Movies addMovie(String movieName, String movieInfo, float movieFee, Time startTime, Time endTime, String streamingTheater);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.model;

import java.sql.Time;

/**
 *
 * @author EKUNSAJUOLA
 */
public class Movies {
    private long id;
    public String movieName;
    public String movieInfo;
    public String streamingTheater;
    public float movieFee;
    public Time startTime;
    public Time endTime;

    public Movies(String movieName, String movieInfo, String streamingTheater, float movieFee, Time startTime, Time endTime) {
        this.movieName = movieName;
        this.movieInfo = movieInfo;
        this.streamingTheater = streamingTheater;
        this.movieFee = movieFee;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Movies{" + "id=" + id + ", movieName=" + movieName + ", movieInfo=" + movieInfo + ", streamingTheater=" + streamingTheater + ", movieFee=" + movieFee + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getStreamingTheater() {
        return streamingTheater;
    }

    public void setStreamingTheater(String streamingTheater) {
        this.streamingTheater = streamingTheater;
    }

    public float getMovieFee() {
        return movieFee;
    }

    public void setMovieFee(float movieFee) {
        this.movieFee = movieFee;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
}

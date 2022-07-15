/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.movie.enums;

/**
 *
 * @author EKUNSAJUOLA
 */
public enum TransactionConstant {
    
    MOVIE("MOVIE"); 
   
    String movie;

    TransactionConstant(String movie) {
        this.movie = movie;
    }
    
    public String getMovie() {
        return movie;
    }
      
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.movie.enums;

/**
 *
 * @author EKUNSAJUOLA
 */
public enum Theater {
    Theatre1(10, "Threatre1"), Threatre2(5, "Threatre2");
    
    int capacity;
    String name;
    
    Theater (int capcity, String name){
        this.capacity = capcity;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getCapcity(){
        return capacity;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.model;

/**
 *
 * @author EKUNSAJUOLA
 */
public class Ticket {
     double totalFees;

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    @Override
    public String toString() {
        return "Ticket{" + "totalFees=" + totalFees + ", id=" + id + '}';
    }
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   
}

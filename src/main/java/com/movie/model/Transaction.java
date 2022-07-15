/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.model;

import java.sql.Date;

/**
 *
 * @author EKUNSAJUOLA
 */
public class Transaction {

    public int transcationId;
    public String type;
    public float total;
    public String theatreName;
    public Date viewDate;
    public String product;

    public Transaction() {
    }

    //...........For food...............
    public Transaction(String type, float total, String product) {
        this.type = type;
        this.total = total;
        this.product = product;
    }

    //..........For Movies.....
    public Transaction(String type, float total, String theatreName, String product, Date viewDate) {
        this.type = type;
        this.total = total;
        this.theatreName = theatreName;
        this.product = product;
        this.viewDate = viewDate;
    }

    public Transaction(String productName, String totalfee, String purchaseDate, String viewDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Transaction{" + "transcationId=" + transcationId + ", type=" + type + ", total=" + total + ", theatreName=" + theatreName + ", viewDate=" + viewDate + ", product=" + product + '}';
    }

    public int getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(int transcationId) {
        this.transcationId = transcationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}

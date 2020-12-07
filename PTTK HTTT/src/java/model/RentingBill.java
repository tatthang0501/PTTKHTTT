/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class RentingBill {
    private Date rentDate;
    private int status;
    private String description;
    private float deposit;
    private float rentFee;
    private int id;
    private Cashier cashier;
    private Client client;
    private ArrayList<RentedBook> rentedBook;
    private Float total;
    
    public RentingBill(){
        
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getRentFee() {
        return rentFee;
    }

    public void setRentFee(float rentFee) {
        this.rentFee = rentFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<RentedBook> getRentedBook() {
        return rentedBook;
    }

    public void setRentedBook(ArrayList<RentedBook> rentedBook) {
        this.rentedBook = rentedBook;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    
    
}

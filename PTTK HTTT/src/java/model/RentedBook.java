/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tatth
 */
public class RentedBook {
    private int id;
    private Book book;
    private BookIssue[] bi;
    private float price;
    private Date rentDate;
    private Date returnDate;
    private float total;

    public RentedBook() {
    }

    public RentedBook(int id, Book book, BookIssue[] bi, float price, Date rentDate, Date returnDate, float total) {
        this.id = id;
        this.book = book;
        this.bi = bi;
        this.price = price;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookIssue[] getBi() {
        return bi;
    }

    public void setBi(BookIssue[] bi) {
        this.bi = bi;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
}

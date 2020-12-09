/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tatth
 */
public class Book {
    private int id;
    private String name;
    private int year;
    private float price;
    private String description;
    private ArrayList<BookAuthor> author;
    private ArrayList<BookCate> cate;

    public Book() {
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<BookAuthor> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<BookAuthor> author) {
        this.author = author;
    }

    public ArrayList<BookCate> getCate() {
        return cate;
    }

    public void setCate(ArrayList<BookCate> cate) {
        this.cate = cate;
    }

    
}

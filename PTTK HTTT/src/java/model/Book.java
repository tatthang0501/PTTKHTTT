/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    private BookAuthor[] author;
    private BookCate[] cate;

    public Book() {
    }

    public Book(int id, String name, int year, float price, String description, BookAuthor[] author, BookCate[] cate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.price = price;
        this.description = description;
        this.author = author;
        this.cate = cate;
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

    public BookAuthor[] getAuthor() {
        return author;
    }

    public void setBookAuthor(BookAuthor[] author) {
        this.author = author;
    }

    public BookCate[] getCate() {
        return cate;
    }

    public void setCate(BookCate[] cate) {
        this.cate = cate;
    }
    
}

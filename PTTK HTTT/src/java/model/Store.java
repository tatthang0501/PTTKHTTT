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
public class Store {
    private int id;
    private String name;
    private String phone;
    private User[] user;
    private Book[] b;
    private Address[] addr;

    public Store() {
    }

    public Store(int id, String name, String phone, User[] user, Book[] b, Address[] addr) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.user = user;
        this.b = b;
        this.addr = addr;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User[] getUser() {
        return user;
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    public Book[] getB() {
        return b;
    }

    public void setB(Book[] b) {
        this.b = b;
    }

    public Address[] getAddr() {
        return addr;
    }

    public void setAddr(Address[] addr) {
        this.addr = addr;
    }
    
    
}

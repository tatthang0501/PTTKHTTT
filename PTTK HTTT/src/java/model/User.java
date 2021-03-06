/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tatth
 */
public class User implements Serializable{
    private String id;
    private Date DOB;
    private int sex;
    private int role;
    private String phone;
    private Account acc;
    private Name name;
    private Store store;
    private ArrayList<Address> addrs;

    public User() {
    }

    public User(int sex, int role, String phone, Account acc, Name name) {
        this.sex = sex;
        this.role = role;
        this.phone = phone;
        this.acc = acc;
        this.name = name;
    }
    
    public User(Date DOB, int sex, int role, String phone, Account acc, Name name) {
        this.DOB = DOB;
        this.sex = sex;
        this.role = role;
        this.phone = phone;
        this.acc = acc;
        this.name = name;
    }

    public User(String id, Date DOB, int sex, int role, String phone, Account acc, Name name, Store store, ArrayList<Address> addrs) {
        this.id = id;
        this.DOB = DOB;
        this.sex = sex;
        this.role = role;
        this.phone = phone;
        this.acc = acc;
        this.name = name;
        this.store = store;
        this.addrs = addrs;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public ArrayList<Address> getAddrs() {
        return addrs;
    }

    public void setAddrs(ArrayList<Address> addrs) {
        this.addrs = addrs;
    }   
}

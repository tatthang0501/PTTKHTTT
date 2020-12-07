/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.Book;
import model.RentedBook;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {
        RentedBookDAO rbDAO = new RentedBookDAO();
        ArrayList<RentedBook> list = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(2);
        Book book2 = new Book();
        book2.setId(3);
        RentedBook rb1 = new RentedBook();
        rb1.setBook(book1);
        RentedBook rb2 = new RentedBook();
        rb2.setBook(book2);
        list.add(rb1);
        list.add(rb2);
        for(RentedBook rb : list){
            System.out.println(rb.getBook().getId());
        }
    }
}

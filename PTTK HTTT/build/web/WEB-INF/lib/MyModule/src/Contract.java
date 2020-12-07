
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Godzuuu
 */
public class Contract {
    private int id;
    private int contactDuration;
    private int numberOfRoomRented;
    private Date checkIn;
    private Client c;
    private Room r;
    public Contract() {
    }

    public Contract(int contactDuration, int numberOfRoomRented, Date checkIn, Client c, Room r) {
        this.contactDuration = contactDuration;
        this.numberOfRoomRented = numberOfRoomRented;
        this.checkIn = checkIn;
        this.c = c;
        this.r = r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactDuration() {
        return contactDuration;
    }

    public void setContactDuration(int contactDuration) {
        this.contactDuration = contactDuration;
    }

    public int getNumberOfRoomRented() {
        return numberOfRoomRented;
    }

    public void setNumberOfRoomRented(int numberOfRoomRented) {
        this.numberOfRoomRented = numberOfRoomRented;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public Room getR() {
        return r;
    }

    public void setR(Room r) {
        this.r = r;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Godzuuu
 */
public class Room {
    private int id;
    private float price;
    private int floor;
    private String type;
    private String description;
    private float electricMeterCount;
    private float waterMeterCount;

    public Room() {
    }

    public Room(float price, int floor, String type, String description, float electricMeterCount, float waterMeterCount) {
        this.price = price;
        this.floor = floor;
        this.type = type;
        this.description = description;
        this.electricMeterCount = electricMeterCount;
        this.waterMeterCount = waterMeterCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getElectricMeterCount() {
        return electricMeterCount;
    }

    public void setElectricMeterCount(float electricMeterCount) {
        this.electricMeterCount = electricMeterCount;
    }

    public float getWaterMeterCount() {
        return waterMeterCount;
    }

    public void setWaterMeterCount(float waterMeterCount) {
        this.waterMeterCount = waterMeterCount;
    }
    
    
}

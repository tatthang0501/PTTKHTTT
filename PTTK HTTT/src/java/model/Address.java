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
public class Address {
    private int id;
    private String houseNumber;
    private String alley;
    private String road;
    private String ward;
    private String district;
    private String city;

    public Address() {
    }

    public Address( String houseNumber, String alley, String road, String ward, String district, String city) {
        this.houseNumber = houseNumber;
        this.alley = alley;
        this.road = road;
        this.ward = ward;
        this.district = district;
        this.city = city;
    }
    
    public Address(int id, String houseNumber, String alley, String road, String ward, String district, String city) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.alley = alley;
        this.road = road;
        this.ward = ward;
        this.district = district;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}

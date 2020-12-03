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
public class Issue {
    private int id;
    private String name;
    private float chargePercent;
    private String description;

    public Issue() {
    }

    public Issue(int id, String name, float chargePercent, String description) {
        this.id = id;
        this.name = name;
        this.chargePercent = chargePercent;
        this.description = description;
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

    public float getChargePercent() {
        return chargePercent;
    }

    public void setChargePercent(float chargePercent) {
        this.chargePercent = chargePercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

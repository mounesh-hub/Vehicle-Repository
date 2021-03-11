package com.mounesh.root.model;


import javax.persistence.*;

@Entity(name = "bike")
public class Bike {

    @Id
    @SequenceGenerator(name = "bike_id_sequence", sequenceName = "bike_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_id_sequence")
    private Long ID;

    @Column(name = "bike_name", unique = true, nullable = false, columnDefinition = "TEXT", length = 300)
    private String bikeName;

    @Column(name = "manufacturer", nullable = false, columnDefinition = "TEXT")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "cost")
    private Integer cost;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String toString(){
        return bikeName + " "+ manufacturer;
    }
}

package com.mounesh.root.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Date;

@Entity
@Table
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="SEQ_JUST_FOR_CAR", allocationSize=1)
    private long id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_manufacturer_name")
    private String manufacturerName;

    @Column(name = "car_manufacturing_year")
    private Date manufacturingYear;

    @Column(name = "car_color")
    private String color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Date getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Date manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

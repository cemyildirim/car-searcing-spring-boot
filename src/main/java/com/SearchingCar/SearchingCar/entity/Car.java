package com.SearchingCar.SearchingCar.entity;


public class Car {

    private String brand; // Marka
    private String model; // Model
    private String type;  // Sınıf

    public Car() {

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public Car(String brand, String model, String type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }



}

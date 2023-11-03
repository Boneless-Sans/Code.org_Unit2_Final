package com.boneless.unit2Final;

public class Device {
    private String type;
    private String brand;
    private double price;
    public Device(){
        this.type = "Laptop";
        this.brand = "Apple";
        this.price = 1199.99;
    }
    public Device(String type, String brand, double price){
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

    public void setType(String type){
        this.type = type;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getType(){return type;}
    public String getBrand(){return brand;}
    public double getPrice(){return price;}

    public String toString(){
        return "Device Type: " + type + "\nBrand: " + brand + "\nPrice: $" + price;
    }
}

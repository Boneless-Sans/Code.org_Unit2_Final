package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Device {
    private String type;
    private String brand;
    private double price;
    private static String model;
    private String trim;
    private int storage;
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

    public void finalizePrice(){
        Scanner scan = new Scanner(System.in);
        setPrice(getPrice() + (getPrice() * 0.06));
        System.out.println("Selected Specifications:");
        System.out.println("Model: " + getModel());
        System.out.println("Trim: " + getTrim());
        if(getStorage() == 1000){
            System.out.println("Storage: 1TB");
        }else{
            System.out.println("Storage: " + getStorage() + "GBs");
        }
        System.out.println("Price (6% Sales Tax): " + getPrice());

        System.out.println("Please set employee code for a %10 discount");
        String name = FileReaderSaver.extractNameWithNumber("employees.sdat", scan.next());
        if(name != null){
            double discount = (getPrice() * 10) / 100;
            setPrice(getPrice() - discount);
            //format so it's not 0.99999999999991
            //instead 0.99
            DecimalFormat df = new DecimalFormat("#.##");
            String format = df.format(getPrice());
            BigDecimal bigDecimal = new BigDecimal(format);
            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
            setPrice(bigDecimal.doubleValue());
            System.out.println("Welcome: " + name);
        }else{
            System.out.println("Invalid Code\n");
        }
        System.out.println("Final Price: " + getPrice());
    }

    public void invalid(){System.out.println("Invalid Choice\n");}
    public String getType(){return type;}
    public String getBrand(){return brand;}
    public double getPrice(){return price;}
    public String getModel(){return model;}
    public String getTrim(){return trim;}
    public int getStorage(){return storage;}

    public String toFile(){
        return "Brand: " + brand + " - Device Type: " + type + " - Price: $" + price;
    }
    public String toString(){
        return "Brand: " + brand + "\nDevice Type: " + type  + "\nPrice: $" + price;
    }
}
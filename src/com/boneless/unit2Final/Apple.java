package com.boneless.unit2Final;

import java.awt.desktop.AppForegroundListener;
import java.util.Scanner;

public class Apple extends Device{
    private static String model;
    private String trim;
    private int storage;
    private double price;
    public Apple(){
        super("iPhone","Apple",999.99);
        this.model = "Pro";
        this.trim = "Max";
        this.storage = 250;
    }
    public Apple(String model, String trim, int storage, double price){
        super(model, "Apple", 999.99);
        this.trim = trim;
        this.price = price;
    }

    public void setModel(String model){
        this.model = model;
    }
    public void setTrim(String trim){
        this.trim = trim;
    }
    public void setStorage(int storage){
        this.storage = storage;
    }

    public String chooseModel(){
        Scanner scan = new Scanner(System.in);
        boolean checkLoop = true;
        String typeChoice;

        while(checkLoop){
            System.out.println("What type of Apple device do you want?");
            System.out.println("iPhone(i) " + "iPad(p) " + "Macbook(m)");
            typeChoice = scan.next();
            if(typeChoice.equalsIgnoreCase("i")){
                this.setModel("iPhone");
                checkLoop = false;
            }else if(typeChoice.equalsIgnoreCase("p")){
                this.setModel("iPad");
            }else if(typeChoice.equalsIgnoreCase("m")){
                this.setModel("Macbook");
            }else{
                System.out.println("Invaild Choice");
            }
        }
        return model;
    }

    public String getModel(){return model;}
    public String getTrim(){return trim;}
    public int getStorage(){return storage;}

    public String toString(){
        return super.toString() + "\nModel: " + model + "\nTrim: " + trim + "\nStorage: " + storage + "GBs";
    }
}

package com.boneless.unit2Final;

import java.awt.desktop.AppForegroundListener;
import java.util.Scanner;

public class Google extends Device{
    private static String model;
    private int storage;
    private double price;
    public Google(){
        super("Pixel","Google",999.99);
        this.model = "4";
        this.storage = 250;
    }
    public Google(String model, int storage, double price){
        super(model, "Google", 999.99);
        this.price = price;
    }

    public void setModel(String model){
        this.model = model;
    }
    public void setStorage(int storage){
        this.storage = storage;
    }

    public String chooseModel(){
        Scanner scan = new Scanner(System.in);
        boolean checkLoop = true;
        String typeChoice;

        while(checkLoop){
            System.out.println("What type of Google device do you want?");
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
    public int getStorage(){return storage;}

    public String toString(){
        return super.toString() + "\nModel: " + model + "\nStorage: " + storage + "GBs";
    }
}

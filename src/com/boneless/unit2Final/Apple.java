package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;

import java.awt.desktop.AppForegroundListener;
import java.util.Scanner;

public class Apple extends Device{
    private static String model;
    private int modelNum;
    private String trim;
    private int trimNum;
    private int storage;
    private int storageNum;
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
            System.out.println("What type of Apple device do you want?\niPhone(i) iPad(p) Macbook(m)");
            typeChoice = scan.next();
            if(typeChoice.equalsIgnoreCase("i")){
                this.setModel("iPhone");
                this.chooseiPhoneTrim();
                modelNum = 6;
                checkLoop = false;
            }else if(typeChoice.equalsIgnoreCase("p")){
                this.setModel("iPad");
                modelNum = 7;
                checkLoop = false;
            }else if(typeChoice.equalsIgnoreCase("m")){
                this.setModel("Macbook");
                checkLoop = false;
                modelNum = 8;
            }else{
                System.out.println("Invalid Choice\n");
            }
        }
        return model;
    }
    public void chooseiPhoneTrim(){
        Scanner scan = new Scanner(System.in);
        boolean checkLoop = true;
        String typeChoice;

        while(checkLoop){
            System.out.println("Please choose type of device\nStandard(s) Standard Plus(z) Pro(p) Pro Max(m)");
            typeChoice = scan.next();
            if(typeChoice.equalsIgnoreCase("s")){
                this.setTrim("Standard");
                this.chooseStorage(false);
                trimNum = 9;
                checkLoop = false;
            }else if(typeChoice.equalsIgnoreCase("z")){
                this.setTrim("Standard Plus");
                this.chooseStorage(false);
                trimNum = 10;
                checkLoop =false;
            }else if(typeChoice.equalsIgnoreCase("p")){
                this.setTrim("Pro");
                this.chooseStorage(true);
                trimNum = 11;
                checkLoop =false;
            }else if(typeChoice.equalsIgnoreCase("m")){
                this.setTrim("Pro Max");
                checkLoop =false;
                trimNum = 12;
                this.chooseStorage(true);
            }else{
                System.out.println("Invalid Choice\n");
            }
        }
    }
    public void chooseStorage(boolean isPro){
        Scanner scan = new Scanner(System.in);
        boolean checkLoop = true;

        if(isPro){
            while(checkLoop){
                System.out.println("\nPlease choose storage size\n250GBs(s) 500GBs(m) 1TB(l)");
                String storageChoice = scan.next();
                if(storageChoice.equalsIgnoreCase("s")){
                    this.storage = 250;
                    storageNum = 14;
                    checkLoop = false;
                }else if(storageChoice.equalsIgnoreCase("m")){
                    this.storage = 500;
                    storageNum = 15;
                    checkLoop = false;
                }else if(storageChoice.equalsIgnoreCase("l")){
                    this.storage = 1000;
                    storageNum = 16;
                    checkLoop = false;
                }else{
                    System.out.println("Invalid Choice\n");
                }
            }
        }else{
            while(checkLoop){
                System.out.println("\nPlease choose storage size\n128GBs(s) 250GBs(m) 500GBs(l)");
                String storageChoice = scan.next();
                if(storageChoice.equalsIgnoreCase("s")){
                    this.storage = 128;
                    storageNum = 13;
                    checkLoop = false;
                }else if(storageChoice.equalsIgnoreCase("m")){
                    this.storage = 250;
                    storageNum = 14;
                    checkLoop = false;
                }else if(storageChoice.equalsIgnoreCase("l")){
                    this.storage = 500;
                    storageNum = 15;
                    checkLoop = false;
                }else{
                    System.out.println("Invalid Choice\n");
                }
            }
        }
        //System.out.println(FileReaderSaver.read("products.sdat", modelNum));
        String[] deviceBuilder = {
                FileReaderSaver.read("products.sdat", modelNum),
                FileReaderSaver.read("products.sdat", trimNum),
                FileReaderSaver.read("products.sdat", storageNum)
        };
        System.out.println(deviceBuilder[0]);
        System.out.println(deviceBuilder[1]);
        System.out.println(deviceBuilder[2]);
    }


    public String getModel(){return model;}
    public String getTrim(){return trim;}
    public int getStorage(){return storage;}

    public String toString(){
        return super.toString() + "\nModel: " + model + "\nTrim: " + trim + "\nStorage: " + storage + "GBs";
    }
}

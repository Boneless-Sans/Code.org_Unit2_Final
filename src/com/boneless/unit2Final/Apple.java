package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;

import java.awt.desktop.AppForegroundListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Apple extends Device{
    private static String model;
    private String trim;
    private int storage;
    private double size;
    private double price;
    private final Scanner scan = new Scanner(System.in);
    public Apple(){
        super("iPhone","Apple",999.99);
        this.model = "Pro";
        this.trim = "Max";
        this.storage = 250;
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
    public void setSize(double size){
        this.size = size;
    }

    public String chooseModel(){
        boolean checkLoop = true;
        String typeChoice;

        while(checkLoop){
            System.out.println("What type of Apple device do you want?\niPhone(i) iPad(p) Macbook(m)");
            typeChoice = scan.nextLine();
            if(typeChoice.equalsIgnoreCase("i")){
                setModel("iPhone");
                checkLoop = false;
                chooseiPhoneTrim();
            }else if(typeChoice.equalsIgnoreCase("p")){
                setModel("iPad");
                checkLoop = false;
                chooseiPadTrim();
            }else if(typeChoice.equalsIgnoreCase("m")){
                setModel("Macbook");
                checkLoop = false;
                chooseMacbookTrim();
            }else{
                invalid();
            }
        }
        return model;
    }
    public void chooseiPhoneTrim() {
        boolean checkLoop = true;

        while (checkLoop) {
            System.out.println("Please choose type of device\nStandard(s) Standard Plus(z) Pro(p) Pro Max(m)");
            String typeChoice = scan.nextLine();
            if (typeChoice.equalsIgnoreCase("s")) {
                setTrim("Standard");
                setPrice(799);
                checkLoop = false;
                chooseStorage(false);
            } else if (typeChoice.equalsIgnoreCase("z")) {
                setTrim("Standard Plus");
                setPrice(899);
                checkLoop = false;
                chooseStorage(false);
            } else if (typeChoice.equalsIgnoreCase("p")) {
                setTrim("Pro");
                setPrice(999);
                checkLoop = false;
                chooseStorage(true);
            } else if (typeChoice.equalsIgnoreCase("m")) {
                setTrim("Pro Max");
                setPrice(1199);
                checkLoop = false;
                chooseStorage(true);
            } else {
                invalid();
            }
        }
    }
    public void chooseiPadTrim(){
        boolean checkLoop = true;

        while(checkLoop){
            System.out.println("\nPlease choose type of iPad\niPad(i) iPad Air(a) iPad Pro(p)");
            String typeChoice = scan.nextLine();
            if(typeChoice.equalsIgnoreCase("i")){
                setTrim("iPad");
                checkLoop = false;
                chooseStorage(false);
            }else if(typeChoice.equalsIgnoreCase("a")){
                setTrim("iPad Air");
                checkLoop = false;
                chooseStorage(false);
            }else if(typeChoice.equalsIgnoreCase("p")){
                System.out.println("\nPlease choose size\nSmall - 11\"(s) Large - 12.9\"(l)");
                String sizeChoice = scan.nextLine();
                if(sizeChoice.equalsIgnoreCase("s")){
                    setTrim("iPad Pro 11\"");
                    setSize(11);
                    checkLoop = false;
                    chooseStorage(true);
                }else if(sizeChoice.equalsIgnoreCase("l")){
                    setTrim("iPad Pro");
                    setSize(12.9);
                    checkLoop = false;
                    chooseStorage(true);
                }else{
                    invalid();
                }
            }else{
                invalid();
            }
        }
    }
    public void chooseMacbookTrim(){
        boolean checkLoop = true;
        while(checkLoop){
            System.out.println("Please choose type the type of Macbook you want\nMacbook Pro(p) Macbook Air(a)");
            String typeChoice = scan.nextLine();
            if(typeChoice.equalsIgnoreCase("p")){
                setTrim("Pro");
                checkLoop = false;
                chooseStorage(true);
            }else if(typeChoice.equalsIgnoreCase("a")){
                setTrim("Air");
                checkLoop = false;
                chooseStorage(true);
            }else{
                invalid();
            }
        }


    }
    public void chooseStorage(boolean isPro) {
        boolean checkLoop = true;

        if (isPro) {
            while (checkLoop) {
                System.out.println("\nPlease choose storage size\n250GBs(s) 500GBs(m) 1TB(l)");
                String storageChoice = scan.nextLine();
                if (storageChoice.equalsIgnoreCase("s")) {
                    setStorage(256);
                    setPrice(getPrice() + 0);
                    checkLoop = false;
                } else if (storageChoice.equalsIgnoreCase("m")) {
                    setStorage(512);
                    setPrice(getPrice() + 100);
                    checkLoop = false;
                } else if (storageChoice.equalsIgnoreCase("l")) {
                    setStorage(1000);
                    setPrice(getPrice() + 200);
                    checkLoop = false;
                } else {
                    invalid();
                }
            }
        } else {
            while (checkLoop) {
                System.out.println("\nPlease choose storage size\n128GBs(s) 250GBs(m) 500GBs(l)");
                String storageChoice = scan.nextLine();
                if (storageChoice.equalsIgnoreCase("s")) {
                    setStorage(128);
                    setPrice(getPrice() + 0);
                    checkLoop = false;
                } else if (storageChoice.equalsIgnoreCase("m")) {
                    setStorage(256);
                    setPrice(getPrice() + 100);
                    checkLoop = false;
                } else if (storageChoice.equalsIgnoreCase("l")) {
                    setStorage(512);
                    setPrice(getPrice() + 200);
                    checkLoop = false;
                } else {
                    invalid();
                }
            }
        }
        finalizePrice();
    }



    public String getModel(){return model;}
    public String getTrim(){return trim;}
    public int getStorage(){return storage;}

    public String toString(){
        return super.toString() + "\nModel: " + model + "\nTrim: " + trim + "\nStorage: " + storage + "GBs";
    }
    //price = price + addon
}

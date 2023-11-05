package com.boneless.unit2Final;

import com.boneless.unit2Final.Device;

import java.awt.*;
import java.util.Scanner;

public class Google extends Device{
    private static String model;
    private String trim;
    private int storage;
    //private double size; //not sure if this going to be used here
    private double price;
    private final Scanner scan = new Scanner(System.in);
    public Google(){
        super("Phone","Google",699);
        this.model = "Pixel";
        this.trim = "8";
        this.storage = 128;
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
    public String chooseType(){
        boolean checkLoop = true;

        while(checkLoop){
            System.out.println("Please Choose type of device\nPixel(p) Tablet(t) PixelBook(b)");
            String input = scan.next();
            if(input.equalsIgnoreCase("p")){
                setModel("Pixel");
                checkLoop = false;
                choosePixelTrim();
            }else if(input.equalsIgnoreCase("t")){
                setModel("Tablet");
                checkLoop = false;
                chooseTabelTrim();
            }else if(input.equalsIgnoreCase("b")){
                setModel("PixelBook");
                checkLoop = false;
                chooseBookTrim();
            }else{
                invalid();
            }
        }
        return model;
    }
    public void choosePixelTrim(){
        System.out.println("Please choose model\nPixel 8(s) Pixel 8 Pro(p) Pixel 7a(a) Pixel Fold(f)");
        String input = scan.next();
        boolean checkLoop = true;
        while(checkLoop){
            if(input.equalsIgnoreCase("s")){
                setTrim("8");
                setPrice(699);
                checkLoop = false;
                chooseStorage(true);
            }else if (input.equalsIgnoreCase("p")){
                setTrim("8 Pro");
                setPrice(999);
                checkLoop = false;
                chooseStorage(false);
            }else if(input.equalsIgnoreCase("a")){
                setTrim("7a");
                setPrice(499);
                setStorage(128);
                checkLoop = false;
            }else if(input.equalsIgnoreCase("f")){
                setTrim("Fold");
                setPrice(1799);
                checkLoop = false;
                chooseStorage(true);
            }else{
                invalid();
            }
        }
    }
    public void chooseBookTrim(){
        System.out.println("Please choose model\nIntel m3 8GBs Ram(s) Intel i5 8GBs(m) Intel i7 16GBs(l)");
        String input = scan.next();
        boolean checkLoop = true;
        while(checkLoop) {
            if (input.equalsIgnoreCase("s")) {
                setTrim("Intel m3 8GBs Ram");
                setPrice(649);
                checkLoop = false;
                chooseStorage(false);
            } else if (input.equalsIgnoreCase("m")) {
                setTrim("Intel i5 8GBs Ram");
                setPrice(99);
                checkLoop = false;
                chooseStorage(true);
            } else if (input.equalsIgnoreCase("l")) {
                setTrim("Intel i7 16GBs");
                setPrice(1399);
                checkLoop = false;
                chooseStorage(true);
            } else {
                invalid();
            }
        }
    }
    public void chooseTabelTrim(){
        System.out.println("Please choose Tablet color\nPorcelain(p) Hazel(h) Rose(r)"); //there is only one
        String input = scan.next();
        boolean checkLoop = true;
        while(checkLoop){
            if(input.equalsIgnoreCase("p")){
                setTrim("Porcelain");
                setPrice(399);
                checkLoop = false;
                chooseStorage(false);
            }else if(input.equalsIgnoreCase("h")){
                setTrim("Hazel");
                setPrice(399);
                checkLoop = false;
                chooseStorage(false);
            }else if(input.equalsIgnoreCase("r")){
                setTrim("Rose");
                setPrice(399);
                checkLoop = false;
                chooseStorage(false);
            }else{
                invalid();
            }
        }
    }
    public void chooseStorage(boolean pro){
        System.out.println("Please choose storage");

        boolean checkLoop = true;
        while(checkLoop) {
            System.out.println("what");
            if (pro) {
                System.out.println("256Gbs(s) 512GBs(m) 1TB(l)");
                String input = scan.next();
                if (input.equalsIgnoreCase("s")) {
                    setStorage(256);
                    checkLoop = false;
                } else if (input.equalsIgnoreCase("m")) {
                    setStorage(512);
                    setPrice(getPrice() + 100);
                    checkLoop = false;
                }else if(input.equalsIgnoreCase("l")){
                    setStorage(1000);
                    setPrice(getPrice() + 200);
                    checkLoop = false;
                }else {
                    invalid();
                }
            }else{
                System.out.println("256Gbs(s) 512GBs(l)");
                String input = scan.next();
                if (input.equalsIgnoreCase("s")) {
                    setStorage(128);
                    checkLoop = false;
                } else if (input.equalsIgnoreCase("l")) {
                    setStorage(256);
                    setPrice(getPrice() + 100);
                    checkLoop = false;
                }else {
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
}
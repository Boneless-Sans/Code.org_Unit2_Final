package com.boneless.unit2Final.util;

import com.boneless.unit2Final.Device;

import javax.swing.*;
import java.util.Scanner;

public class ProductWriter extends JFrame {
    public ProductWriter(){
        FileReaderSaver.resetFile("products.sdat");
        Scanner input = new Scanner(System.in);
        Device test = new Device();
        System.out.println("Device: ");
        test.setType(input.next());

        int lineToWrite = Integer.parseInt(FileReaderSaver.read("products.sdat", 1));
        System.out.println(test.toFile());
        FileReaderSaver.save(test.toFile(), "products.sdat", lineToWrite);
        System.out.println(test);
    }
    public static void main(String[] args){
        new ProductWriter();
    }
}

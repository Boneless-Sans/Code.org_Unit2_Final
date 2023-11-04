package com.boneless.unit2Final.util;

import com.boneless.unit2Final.Device;

import javax.swing.*;
import java.util.Scanner;
import java.io.IOException;

public class ProductWriter extends JFrame {
    public ProductWriter() {
        Scanner input = new Scanner(System.in);
        Device test = new Device();
        System.out.println("Device: ");
        test.setType(input.next());

        int lineToWrite = Integer.parseInt(FileReaderSaver.read("products.sdat",1));
        String dataToWrite = test.toFile();

        FileReaderSaver.save(dataToWrite, "products.sdat");
        System.out.println("Data saved to products.sdat (Line " + lineToWrite + ": " + dataToWrite + ")");

        System.out.println(test);
    }

    public static void main(String[] args) {
        new ProductWriter();
    }
}

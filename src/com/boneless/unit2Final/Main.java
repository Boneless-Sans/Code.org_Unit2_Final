package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;
import com.boneless.unit2Final.Apple;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main extends JFrame {
    private static JFrame mainMenu;
//    public static void main(String[] args) {
//        mainMenu = new JFrame();
//        mainMenu.setSize(500,500);
//        mainMenu.setLayout(null);
//        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JTextField employeeNum = new JTextField();
//        employeeNum.setBounds(0,0,300,200);
//        employeeNum.setFont(new Font("Arial", Font.PLAIN,20));
//
//        JButton submit = new JButton("Submit");
//        submit.setBounds(200,350,110,50);
//        submit.addActionListener(e -> {
//            int output = Integer.parseInt(employeeNum.getText());
//            System.out.println("Welcome, " + FileReaderSaver.extractNamesWithNumber("employees.sdat", String.valueOf(output)));
//        });
//
//        mainMenu.add(employeeNum);
//        mainMenu.add(submit);
//        mainMenu.setVisible(true);
//    }
    public static void main(String[] args) {
        boolean checkLoop = true;
        String brandChoice;
        String typeChoice;

        Device customDevice = new Device("Phone", "Apple", 50);
        Scanner scan = new Scanner(System.in);
        System.out.println("What Brand of Deivce Would You Like?");
        System.out.println("Apple(a) " + "Google(g) " + "Samsung(s) + OnePlus(o)");
        while (checkLoop) {
            brandChoice = scan.next();
            if (brandChoice.equalsIgnoreCase("a")) {
                Apple appleDevice = new Apple();
                customDevice.setBrand("Apple");
                checkLoop = false;
                customDevice.setType(appleDevice.chooseModel());
            } else if (brandChoice.equalsIgnoreCase("g")) {
                customDevice.setBrand("Google");
                checkLoop = false;
            } else if (brandChoice.equalsIgnoreCase("s")) {
                customDevice.setBrand("Samsung");
                checkLoop = false;
            } else if (brandChoice.equalsIgnoreCase("o")) {
                customDevice.setBrand("OnePlus");
                checkLoop = false;
            } else {
                System.out.println("Invaild Choice");
                System.out.println("What Brand of Deivce Would You Like?");
                System.out.println("Apple(a) " + "Google(g) " + "Samsung(s) + OnePlus(o)");
            }
        }
    }
}

//Tech store, phones, tablets, laptops, desktops
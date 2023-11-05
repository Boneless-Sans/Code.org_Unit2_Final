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

    //there is a code in place for making new device, brand, etc. due to time constraints, I cant finish them
    public static void main(String[] args) {
        boolean checkLoop = true;
        String brandChoice;

        Device customDevice = new Device("Phone", "Apple", 50);
        Scanner scan = new Scanner(System.in);
        System.out.println("What Brand of Device Would You Like?");
        System.out.println("Apple(a) " + "Google(g)");
        while (checkLoop) {
            brandChoice = scan.next();
            if (brandChoice.equalsIgnoreCase("a")) {
                Apple appleDevice = new Apple();
                customDevice.setBrand("Apple");
                checkLoop = false;
                customDevice.setType(appleDevice.chooseModel());
            } else if (brandChoice.equalsIgnoreCase("g")) {
                Google googleDevice = new Google();
                customDevice.setBrand("Google");
                checkLoop = false;
                customDevice.setType(googleDevice.chooseType());
            }else {
                System.out.println("Invalid Choice");
                System.out.println("What Brand of Device Would You Like?");
                System.out.println("Apple(a) " + "Google(g)");
            }
        }
    }
}

//Tech store, phones, tablets, laptops, desktops
//Due to time constraints, JFrame will not be implemented, as well as saving data.
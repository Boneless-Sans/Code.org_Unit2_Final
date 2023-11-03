package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private static JFrame mainMenu;
    public static void main(String[] args) {
        mainMenu = new JFrame();
        mainMenu.setSize(500,500);
        mainMenu.setLayout(null);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField employeeNum = new JTextField();
        employeeNum.setBounds(0,0,300,200);
        employeeNum.setFont(new Font("Arial", Font.PLAIN,20));

        JButton submit = new JButton("Submit");
        submit.setBounds(200,350,110,50);
        submit.addActionListener(e -> {
            int output = Integer.parseInt(employeeNum.getText());
            System.out.println("Welcome, " + FileReaderSaver.extractNamesWithNumber("employees.json", String.valueOf(output)));
        });

        mainMenu.add(employeeNum);
        mainMenu.add(submit);
        mainMenu.setVisible(true);
    }
}

//Tech store, phones, tablets, laptops, desktops
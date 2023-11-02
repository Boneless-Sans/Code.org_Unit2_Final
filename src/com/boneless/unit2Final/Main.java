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

        JTextField employeeNum = new JTextField();
        employeeNum.setBounds(0,0,300,200);
        employeeNum.setFont(new Font("Arial", Font.PLAIN,20));

        JButton submit = new JButton("Submit");

        System.out.println(FileReaderSaver.extractNamesWithNumber("employees.json", employeeNum.getText()));

        mainMenu.add(employeeNum);
        mainMenu.setVisible(true);
    }
}
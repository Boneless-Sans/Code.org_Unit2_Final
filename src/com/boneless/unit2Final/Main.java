package com.boneless.unit2Final;

import com.boneless.unit2Final.util.FileReaderSaver;

import javax.swing.*;
public class Main extends JFrame {
    private static JFrame mainMenu;
    public static void main(String[] args) {
        mainMenu = new JFrame();
        mainMenu.setSize(500,500);
        mainMenu.setLayout(null);

        System.out.println(FileReaderSaver.extractNamesWithNumber("employees.json", "12345"));

        mainMenu.setVisible(true);
    }
}
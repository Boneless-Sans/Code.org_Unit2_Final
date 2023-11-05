package com.boneless.unit2Final.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderSaver {
    public static void save(Object data, String fileName) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            String topLine = file.readLine(); // Read the top line
            int currentLine = 1; // Initialize the line counter

            if (topLine != null) {
                try {
                    currentLine = Integer.parseInt(topLine); // Try to parse the top line as an integer
                } catch (NumberFormatException e) {
                    // The top line is not a valid integer, indicating an empty file
                    currentLine = 1; // Set the line counter to 1 for an empty file
                }
            }

            long position = 0;
            boolean fileIsEmpty = true; // Flag to check if the file is empty

            String line;
            while ((line = file.readLine()) != null) {
                if (!line.isEmpty()) {
                    fileIsEmpty = false; // The file is not empty
                } else {
                    // Found an empty line, write the data to this line
                    file.seek(position);
                    // Format the data with a delimiter to preserve spaces
                    file.writeBytes(data.toString() + "~~~\n");
                    System.out.println("Data saved to " + fileName + " (Line " + (position / 4) + ": " + data + ")");
                    return; // Exit the loop after writing the data
                }
                position = file.getFilePointer();
            }

            if (fileIsEmpty) {
                // If the file is empty, write the data to the first line
                file.seek(0);
                // Format the data with a delimiter to preserve spaces
                file.writeBytes(data.toString() + "~~~\n");
                System.out.println("Data saved to " + fileName + " (Line 1: " + data + ")");
            } else {
                // If no empty line is found, append the data to the end of the file
                file.seek(file.length());
                // Format the data with a delimiter to preserve spaces
                file.writeBytes(data.toString() + "~~~\n");
                System.out.println("Data saved to " + fileName + " (Line " + (file.length() / 4) + ": " + data + ")");
            }

            // Increment the line number at the top line for the next entry
            file.seek(0);
            file.writeBytes(String.valueOf(currentLine + 1) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void resetFile(String fileName) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            file.setLength(0); // Wipe the file
            file.writeBytes("1\n"); // Set the top line to "1"
            System.out.println("File " + fileName + " has been reset.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName, int lineNumber) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    return line; // Return the entire line as plain text
                }
                currentLine++;
            }

            return "Line not found.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading the file.";
        }
    }

    public static String extractNameWithNumber(String fileName, String targetNumber) {
        if (fileName == null || targetNumber == null) {
            return null; // Return null if no value is given for fileName or targetNumber
        }

        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile(".*\\b" + Pattern.quote(targetNumber) + "\\b.*");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    // If the line contains the target number, extract and return the name
                    String[] parts = line.split("-"); // Assuming the name is separated by a hyphen
                    if (parts.length == 2) {
                        String name = parts[0].trim();

                        // Custom logic to remove unwanted characters
                        return name;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return null if the number is not found in the file or if other exceptions occur
        return null;
    }

    public static boolean delete(String fileName) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                return true; // File was successfully deleted
            } else {
                return false; // Failed to delete the file
            }
        } else {
            return false; // File doesn't exist
        }
    }
    public static boolean check(String fileName){
        if(fileName.indexOf('/') == -1){
            fileName = "src/resource/data" + fileName;
        }
        File file = new File(fileName);
        return file.exists();
    }
}

package com.boneless.unit2Final.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderSaver {
    public static void save(Object data, String fileName, int lineNumber) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            if (lineNumber <= 1) {
                // If lineNumber is 1 or less, write the updated content and reset the counter
                file.setLength(0); // Wipe the file
                file.writeBytes("1\n"); // Set the top line to "1"
            } else {
                int currentLine = 0;
                long position = 0;

                while (currentLine < lineNumber - 1) {
                    // Find the position of the start of the target line
                    String line = file.readLine();
                    if (line == null) {
                        break; // Line number exceeds the number of lines in the file
                    }
                    position = file.getFilePointer();
                    currentLine++;
                }

                // Move to the position of the target line
                file.seek(position);

                // Write the updated content
                file.writeBytes(data.toString() + "\n");
            }

            System.out.println("Data saved to " + fileName + " (Line " + lineNumber + ": " + data + ")");
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

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 0;

            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine == lineNumber) {
                    return line; // Return the specific line
                }
            }

            // If lineNumber is greater than the number of lines in the file, return an empty string.
            if (lineNumber > currentLine) {
                return "";
            }

            return "Line not found.";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading the file.";
        }
    }
    public static List<String> extractNamesWithNumber(String fileName, String targetNumber) {
        if (fileName.indexOf('/') == -1) {
            // No directory provided, use the default directory
            fileName = "src/resource/data/" + fileName;
        }

        List<String> matchingNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile(".*\\b" + Pattern.quote(targetNumber) + "\\b.*");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    // If the line contains the target number, extract and add the name to the list
                    String[] parts = line.split("-"); // Assuming the name is separated by a hyphen
                    if (parts.length == 2) {
                        String name = parts[0].trim();

                        // Custom logic to remove unwanted characters
                        matchingNames.add(name);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchingNames;
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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        class FileSummaryReport {

            public static void main(String[] args) {
                // Create a JFileChooser and restrict it to text files
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
                fileChooser.setFileFilter(filter);

                // Show the file chooser and wait for the user to select a file
                int result = fileChooser.showOpenDialog(null);
                if (result != JFileChooser.APPROVE_OPTION) {
                    System.out.println("No file selected.");
                    return;
                }

                // Get the selected file and print its name
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("File selected: " + selectedFile.getName());

                // Open the file and read it line by line, counting lines, words, and characters
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineCount++;

                        // Count the number of words on the line
                        String[] words = line.split("\\s+");
                        wordCount += words.length;

                        // Count the number of characters on the line
                        charCount += line.length();
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    return;
                }

                // Print the summary report
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);
            }
        }

    }
}
package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    public static int countWords(String text) {
        String[] words = text.split("\\W+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        if (choice == 1) {
            System.out.print("Enter the text: ");
            String inputText = scanner.nextLine();
            int totalWords = countWords(inputText);
            System.out.println("Total number of words: " + totalWords);
        } else if (choice == 2) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                StringBuilder fileText = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    fileText.append(line).append("\n");
                }
                int totalWords = countWords(fileText.toString());
                System.out.println("Total number of words: " + totalWords);
            } catch (IOException e) {
                System.out.println("Error: File not found.");
            }
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }
}
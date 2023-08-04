package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playGame();
    }

    public static int generateRandomNumber(int minRange, int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange - minRange + 1) + minRange;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess (between 1 and 100): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void evaluateGuess(int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (attempts < maxAttempts) {
            int userGuess = getUserGuess(scanner);
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again!");
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again!");
            } else {
                System.out.printf("Congratulations! You guessed the number %d in %d attempts.%n", randomNumber, attempts);
                break;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.printf("Sorry, you've reached the maximum number of attempts. The correct number was %d.%n", randomNumber);
        }

        scanner.close();
    }

    public static void playGame() {
        int minRange = 1;
        int maxRange = 100;
        int randomNumber = generateRandomNumber(minRange, maxRange);
        evaluateGuess(randomNumber);
    }
}

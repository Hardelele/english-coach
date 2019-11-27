package com.github.hardelele.englishcoach;

import java.util.Scanner;

public class UserInterface {

    public void printMenu() {
        System.out.println("|-------------------------------------|");
        System.out.println("|           Able actions              |");
        System.out.println("|         1. Load wordbook            |");
        System.out.println("|         2. Save wordbook            |");
        System.out.println("|         3. Add new word             |");
        System.out.println("|         4. Remove word              |");
        System.out.println("|         5. Start test               |");
        System.out.println("|-------------------------------------|");
        System.out.println("|Choose one and input number of chosen:");
        System.out.println("|-------------------------------------|");
        System.out.print("| ");
    }

    public void printBorder() {
        System.out.println("|-------------------------------------|");
    }

    public void printQuestion(Question question) {
        String[] options = question.getOptions();
        for (int counter = 0; counter < 4; counter++) {
            System.out.println((counter+1) + options[counter]);
        }
    }

    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

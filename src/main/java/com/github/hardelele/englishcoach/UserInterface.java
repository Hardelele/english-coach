package com.github.hardelele.englishcoach;

import java.util.HashMap;
import java.util.Map;
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
        System.out.println("|         6. Print wordbook           |");
        System.out.println("|         7. Exit                     |");
        System.out.println("|-------------------------------------|");
        System.out.println("|Choose one and input number of chosen:");
        System.out.println("|-------------------------------------|");
          System.out.print("| ");
    }

    public void printInputError() {
        System.out.println("|-------------------------------------|");
        System.out.print("| ");
           System.err.print("Error! Wrong input data!");
                                  System.out.println("            |");
    }

    public void printQuestion(Question question) {
        System.out.println("|-------------------------------------|");
        System.out.println("| Translate word: " + question.getEnglishWordAnswer());

        System.out.println("|-------------------------------------|");
        String[] options = question.getOptions();
        for (int counter = 0; counter < 4; counter++) {
            System.out.print("|             ");
            System.out.print((counter+1) + " " + options[counter] + "\n");
        }
        System.out.println("|-------------------------------------|");
          System.out.print("| ");
    }

    public void printAskEngWord() {
        System.out.println("|-------------------------------------|");
        System.out.println("|Enter english word:");
        System.out.println("|-------------------------------------|");
          System.out.print("| ");
    }

    public void printAskRusWord() {
        System.out.println("|-------------------------------------|");
        System.out.println("|Enter translate of word:");
        System.out.println("|-------------------------------------|");
          System.out.print("| ");
    }

    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int number = -10;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}
        return number;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printWordbook(HashMap<String,String> wordbook) {
            System.out.println("|-------------------------------------|");
        if (wordbook.isEmpty()) {
            System.out.println("| This wordbook is empty!             |");
        } else {
            System.out.println("| id | words (EN::RU)                 |");
            System.out.println("|-------------------------------------|");
        }
        int counter = 0;
        for (Map.Entry<String, String> words : wordbook.entrySet()) {
            counter++;
            if (counter<10) {
                System.out.println("| 0" + counter + " | " + words.getKey() + " :: " + words.getValue());
            } else {
                System.out.println("| " + counter + " | " + words.getKey() + " :: " + words.getValue());
            }
        }
    }

    public void printResult(Test test) {
            System.out.println("|-------------------------------------|");
        if (test.getResult()<10) {
            System.out.println("| Test is over! Right answers: 0" + test.getResult() + "/10"  );
        } else {
            System.out.println("| Test is over! Right answers: " + test.getResult() + "/10"  );
        }
    }

    public void printAnswer(Question question, int userAnswerId) {
        String correctAnswer = question.getRussianWordAnswer();
        System.out.println("|-------------------------------------|");
          System.out.print("| " + correctAnswer);
        if(question.checkAnswer(userAnswerId)) {
            System.out.print(" score +1 \n");
        } else {
            System.out.print("\n");
        }
    }

    public void printTestStart() {
        System.out.println("|-------------------------------------|");
        System.out.println("|    Test started!   10 questions:    |");
    }

    public void printFileNameAsk() {
        System.out.println("|-------------------------------------|");
        System.out.println("| Enter file name:                    |");
        System.out.println("|-------------------------------------|");
          System.out.print("| ");
    }

}

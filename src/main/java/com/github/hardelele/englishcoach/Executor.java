package com.github.hardelele.englishcoach;

public class Executor {

    WordBook wordBook = new WordBook();

    UserInterface userInterface = new UserInterface();

    Executor() {
        menu();
    }

    public void menu() {
        userInterface.printMenu();
        chooseAction();
    }

    public void chooseAction() {
        int choose = userInterface.inputInt();

        switch (choose) {
            case 1:
                loadWordbook();
                break;
            case 2:
                saveWordbook();
                break;
            case 3:
                addNewWord();
                break;
            case 4:
                removeWord();
                break;
            case 5:
                startTest();
                break;
            case 6:
                printWordbook();
                break;
            case 7:
                System.exit(1);
                break;
            default:
                printError();
                break;
        }
    }

    public void startTest() {
    }

    public void removeWord() {
        String engWord = inputEngWord();
        wordBook.removeWordFromWordbook(engWord);
        menu();
    }

    public void printError() {
        userInterface.printInputError();
        menu();
    }

    public void saveWordbook() {
        String fileName = userInterface.inputString();
        wordBook.load(fileName);
        menu();
    }

    public void loadWordbook() {
        String fileName = userInterface.inputString();
        wordBook.save(fileName);
        menu();
    }

    public void printWordbook() {
        userInterface.printWordbook(wordBook.getWordbook());
        menu();
    }

    public void addNewWord() {
        String engWord = inputEngWord();
        String rusWord = inputRusWord();
        wordBook.addWordToWordbook(engWord,rusWord);
        menu();
    }

    private String inputEngWord() {
        userInterface.printAskEngWord();
        return userInterface.inputString();
    }

    private String inputRusWord() {
        userInterface.printAskRusWord();
        return userInterface.inputString();
    }
}

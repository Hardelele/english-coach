package com.github.hardelele.englishcoach;

public class Menu {

    UserInterface userInterface = new UserInterface();

    Menu() {
        run();
    }

    public void run() {
        userInterface.printMenu();
        chooseAction();
    }

    public void chooseAction() {
        int choose = userInterface.inputInt();

        switch (choose) {
            case 1:

                break;
        }
    }
}

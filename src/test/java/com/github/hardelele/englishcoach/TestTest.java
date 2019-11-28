package com.github.hardelele.englishcoach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTest {

    UserInterface userInterface = new UserInterface();

    @Test
    public void createNewQuestionTest() {
        WordBook wordBook = new WordBook();
        wordBook.addWordToWordbook("one", "один");
        wordBook.addWordToWordbook("two", "два");
        wordBook.addWordToWordbook("three", "три");
        wordBook.addWordToWordbook("four", "четыре");
        wordBook.addWordToWordbook("five", "пять");
        wordBook.addWordToWordbook("six", "шесть");
        wordBook.addWordToWordbook("seven", "семь");
        wordBook.addWordToWordbook("eight", "восемь");
        wordBook.addWordToWordbook("nine", "девять");
        wordBook.addWordToWordbook("ten", "десять");

        com.github.hardelele.englishcoach.Test test = new com.github.hardelele.englishcoach.Test();
        Question question = test.createNewQuestion(wordBook.getWordbook(),"ten");

        userInterface.printQuestion(question);

        int expected = 1;
        int actual = 0;

        String[] options = question.getOptions();
        int answerId = -1;
        for (int counter = 0; counter < 4; counter++) {
            if (options[counter].equals("десять")) {
                actual++;
                answerId = counter;
            }
        }

        assertEquals(expected,actual);
        assertTrue(question.checkAnswer(answerId));
    }

    @Test
    public void generateTest() {
        WordBook wordBook = new WordBook();
        wordBook.addWordToWordbook("one", "один");
        wordBook.addWordToWordbook("two", "два");
        wordBook.addWordToWordbook("three", "три");
        wordBook.addWordToWordbook("four", "четыре");
        wordBook.addWordToWordbook("five", "пять");
        wordBook.addWordToWordbook("six", "шесть");
        wordBook.addWordToWordbook("seven", "семь");
        wordBook.addWordToWordbook("eight", "восемь");
        wordBook.addWordToWordbook("nine", "девять");
        wordBook.addWordToWordbook("ten", "десять");

        userInterface.printWordbook(wordBook.getWordbook());

        com.github.hardelele.englishcoach.Test test = new com.github.hardelele.englishcoach.Test();
        test.generate(wordBook.getWordbook());
        Question[] questions = test.getQuestions();

        for (int counter = 0; counter < 10; counter++) {
            userInterface.printQuestion(questions[counter]);
        }
    }
}

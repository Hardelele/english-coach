package com.github.hardelele.englishcoach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionTest {

    public WordBook getWordBook() {
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
        return wordBook;
    }

    @Test
    public void setRandomOptionsTest() {
        WordBook wordBook = getWordBook();

        Question question = new Question();
        question.setRandomOptions(wordBook.getWordbook());

        String[] options = question.getOptions();
        for (int counter = 0; counter < 4; counter++) {
            System.out.println(options[counter]);
        }
    }

    @Test
    public void setupQuestionTest() {
        WordBook wordBook = getWordBook();

        Question question = new Question();
        question.setupQuestion(wordBook.getWordbook(),"nine");

        String[] options = question.getOptions();
        for (int counter = 0; counter < 4; counter++) {
            System.out.println(options[counter]);
        }
    }

    @Test
    public void checkAnswerTest() {
        WordBook wordBook = getWordBook();

        String answer = "nine";

        Question question = new Question();
        question.setupQuestion(wordBook.getWordbook(), answer);

        String[] options = question.getOptions();
        int id = -1;

        for (int counter = 0; counter < 4; counter++) {
            System.out.println(counter + " " + options[counter]);
            if (options[counter].equals(wordBook.getTranslate(answer))) {
                id = counter;
            }
        }

        assertTrue(question.checkAnswer(id));
    }
}

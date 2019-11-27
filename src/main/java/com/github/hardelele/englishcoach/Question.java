package com.github.hardelele.englishcoach;

import java.util.*;

public class Question {

    private String englishWordAnswer;

    private String russianWordAnswer;

    private String[] options = new String[4];

    public void setRandomOptions(HashMap<String,String> wordBook) {
        ArrayList<String> translatesList = new ArrayList<String>();

        for (String value : wordBook.values()) {
            translatesList.add(value);
        }

        Collections.shuffle(translatesList);
        translatesList.remove(wordBook.get(englishWordAnswer));

        for (int counter = 0; counter < 4; counter++) {
            options[counter] = translatesList.get(counter);
        }
    }

    public void setupQuestion(HashMap<String,String> wordBook, String englishWordAnswer) {
        setEnglishWordAnswer(englishWordAnswer);
        setRussianWordAnswer(wordBook.get(englishWordAnswer));

        HashMap<String, String> cloneOfWordBook = (HashMap<String, String>) wordBook.clone();
        cloneOfWordBook.remove(englishWordAnswer);
        setRandomOptions(cloneOfWordBook);

        Random generator = new Random();
        options[generator.nextInt(4)] = wordBook.get(englishWordAnswer);
    }

    public void setEnglishWordAnswer(String englishWordAnswer) {
        this.englishWordAnswer = englishWordAnswer;
    }

    public boolean checkAnswer(int receivedAnswerId) {
        return options[receivedAnswerId].equals(russianWordAnswer);
    }

    public String[] getOptions() {
        return options;
    }

    public void setRussianWordAnswer(String russianWordAnswer) {
        this.russianWordAnswer = russianWordAnswer;
    }
}

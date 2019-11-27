package com.github.hardelele.englishcoach;

public class Question {

    String queriedWord;

    String[] options = new String[4];

    public boolean checkAnswer(int receivedAnswerId, String correctAnswer) {
        return options[receivedAnswerId].equals(correctAnswer);
    }

}

package com.github.hardelele.englishcoach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test {
    Random random = new Random();

    UserInterface userInterface = new UserInterface();

    Question[] questions = new Question[10];

    int result = -1000;

    public void start() {
        userInterface.printTestStart();
        for (int questionNumber = 0; questionNumber < 10; questionNumber++) {
            userInterface.printQuestion(questions[questionNumber]);
            int answer = userInterface.inputInt();
            if (questions[questionNumber].checkAnswer(answer)) {
                result++;
            }
            userInterface.printAnswer(questions[questionNumber],answer);
        }
    }

    public void generate(HashMap<String,String> wordBook) {
        ArrayList<String> englishWordsList = new ArrayList<String>();

        for (String key : wordBook.keySet()) {
            englishWordsList.add(key);
        }

        for (int counter = 0; counter < 10; counter++) {
            int answerId = random.nextInt(englishWordsList.size());
            String englishWordAnswer = englishWordsList.get(answerId);
            englishWordsList.remove(answerId);
            questions[counter] = createNewQuestion(wordBook, englishWordAnswer);
        }

        result = 0;
    }

    public Question createNewQuestion(HashMap<String,String> wordBook, String englishWordAnswer) {
        Question question = new Question();
        question.setupQuestion(wordBook, englishWordAnswer);
        return question;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getResult() {
        return result;
    }
}

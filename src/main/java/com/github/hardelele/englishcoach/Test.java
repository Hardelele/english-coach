package com.github.hardelele.englishcoach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test {
    Random random = new Random();

    Question[] questions = new Question[10];

    public void start() {

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
    }

    public Question createNewQuestion(HashMap<String,String> wordBook, String englishWordAnswer) {
        Question question = new Question();
        question.setupQuestion(wordBook, englishWordAnswer);
        return question;
    }
}

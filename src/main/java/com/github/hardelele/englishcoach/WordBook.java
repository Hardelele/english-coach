package com.github.hardelele.englishcoach;

import java.io.IOException;
import java.util.HashMap;

public class WordBook {

    private HashMap<String,String> wordbook = new HashMap<String, String>();

    public void saveWordbook(String fileName) {
        try {
            WordsSerializer.save(wordbook,fileName);
        } catch (IOException e) {
            System.out.println("IOException: " + fileName + " does not exist");
        }
    }

    public void loadWordbook(String fileName) {
        try {
            wordbook.putAll(WordsSerializer.load(fileName));
        } catch (IOException e) {
            System.out.println("IOException: " + fileName + " does not exist");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
    }

    public void addWordToWordbook(String englishWord, String russianTranslate) {
        wordbook.put(englishWord,russianTranslate);
    }

    public void removeWordFromWordbook(String englishWord) {
        wordbook.remove(englishWord);
    }

    public String getTranslate(String englishWord) {
        return wordbook.get(englishWord);
    }
}

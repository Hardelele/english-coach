package com.github.hardelele.englishcoach;

import java.io.IOException;
import java.util.HashMap;

public class WordBook {

    private HashMap<String,String> wordbook = new HashMap<String, String>();

    public void save(String fileName) {
        try {
            WordsSerializer.save(wordbook,fileName);
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }

    public void load(String fileName) {
        try {
            wordbook = WordsSerializer.load(fileName);
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

    public HashMap<String, String> getWordbook() {
        return wordbook;
    }

    public void parseFromTxt(String fileName) {
        try {
            wordbook = WordsSerializer.parseFromTxt(fileName);
        } catch (IOException e) {
            System.err.println("Parse error!");
        }
    }
}

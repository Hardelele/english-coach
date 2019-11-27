package com.github.hardelele.englishcoach;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordBookTest {

    @Test
    public void saveAndLoadWordbookTest() {
        WordBook wordBook = new WordBook();
        wordBook.addWordToWordbook("new","новый");

        wordBook.save("wordbook1");

        wordBook.addWordToWordbook("word", "слово");

        wordBook.load("wordbook1");

        HashMap<String,String> actual = wordBook.getWordbook();
        HashMap<String,String> expected = new HashMap<String, String>();

        expected.put("new", "новый");

        assertEquals(expected, actual);
    }

    @Test
    public void addWordToWordbookTest() {
        String word = "word";
        String translate = "слово";

        WordBook wordBook = new WordBook();
        wordBook.addWordToWordbook(word,translate);

        HashMap<String,String> actual = wordBook.getWordbook();
        HashMap<String,String> expected = new HashMap<String, String>();
        expected.put(word,translate);

        assertEquals(actual,expected);
    }

    @Test
    public void removeWordFromWordbookTest() {
        WordBook wordBook = new WordBook();

        wordBook.addWordToWordbook("new","новый");
        wordBook.removeWordFromWordbook("new");

        String actual = wordBook.getTranslate("new");
        assertEquals(null, actual);
    }

    @Test
    public void getTranslateTest() {
        WordBook wordBook = new WordBook();

        wordBook.addWordToWordbook("new","новый");
        String actual = wordBook.getTranslate("new");

        String expected = "новый";
        assertEquals(expected, actual);
    }
}

package com.github.hardelele.englishcoach;

import java.io.*;
import java.util.HashMap;

public class WordsSerializer {
    public static void save(HashMap<String,String> wordbook, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(wordbook);
        objectOutputStream.close();
    }

    public static HashMap<String,String> load(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<String,String> wordbook = (HashMap<String,String>) objectInputStream.readObject();
        objectInputStream.close();
        return wordbook;
    }
}

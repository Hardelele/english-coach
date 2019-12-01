package com.github.hardelele.englishcoach;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

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

    public static HashMap<String,String> parseFromTxt(String fileName) throws IOException {

        HashMap<String,String> wordbook = new HashMap<>();

        File inputFile = new File(fileName);

        if(!inputFile.exists()) {
            inputFile.createNewFile();
        }

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLine = bufferedReader.readLine();

        StringTokenizer tokenizer;

        while (currentLine != null) {
            tokenizer = new StringTokenizer(currentLine,"::");

            String word = tokenizer.nextToken();
            String translate = tokenizer.nextToken();

            wordbook.put(word,translate);

            currentLine = bufferedReader.readLine();
        }

        return wordbook;
    }
}

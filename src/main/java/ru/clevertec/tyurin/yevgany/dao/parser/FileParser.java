package ru.clevertec.tyurin.yevgany.dao.parser;

import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private static FileParser instance;

    FileParser() {}

    public static FileParser getInstance() {
        if (instance == null) {
            instance = new FileParser();
        }
        return instance;
    }

    public List<String[]> parseFile(String fileName) throws FileReadingException {
        InputStream in = this.getClass().getResourceAsStream("/" + fileName);
        List<String[]> inventoryList = new ArrayList<>();
        String invLine = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while ((invLine = reader.readLine()) != null) {
                inventoryList.add(invLine.split(","));
            }
        } catch (IOException ex) {
            throw new FileReadingException("File " + fileName + " can't be read");
        }
        return inventoryList;
    }
}
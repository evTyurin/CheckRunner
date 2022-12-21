package ru.clevertec.tyurin.yevgany.util;

import ru.clevertec.tyurin.yevgany.model.Check;

import java.io.FileWriter;
import java.io.IOException;

public class FileCheckWriter extends CheckWriter{

    private Check check;

    public FileCheckWriter(Check check) {
        super();
        this.check = check;
    }

    @Override
    public void write() {
        try(FileWriter fileWriter = new FileWriter("check.txt")) {
            fileWriter.write(createCheck(check));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

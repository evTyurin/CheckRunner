package ru.clevertec.tyurin.yevgany.argumentParser;

import java.util.Arrays;
import java.util.List;

public class FileParser implements Parsable {

    @Override
    public List<String> parse(String[] arguments){
        return Arrays
                .stream(arguments)
                .filter(arg -> arg.endsWith(".txt"))
                .toList();
    }
}

package ru.clevertec.tyurin.yevgany.argumentParser;

import java.util.Arrays;
import java.util.List;

public class ProductParser implements Parsable {

    @Override
    public List<String> parse(String[] arguments){
        return Arrays
                .stream(arguments)
                .filter(arg -> arg.matches("([0-9]+\\-{1}[0-9]+)"))
                .toList();
    }
}

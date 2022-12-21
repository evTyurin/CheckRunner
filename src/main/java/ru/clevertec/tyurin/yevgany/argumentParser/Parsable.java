package ru.clevertec.tyurin.yevgany.argumentParser;

import java.util.List;

public interface Parsable {
    List<String> parse(String[] arguments);
}

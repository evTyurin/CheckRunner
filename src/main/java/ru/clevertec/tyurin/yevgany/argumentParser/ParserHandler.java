package ru.clevertec.tyurin.yevgany.argumentParser;

public class ParserHandler {
    private static final ParserHandler instance = new ParserHandler();

    private final Parsable discountCardParser;
    private final Parsable fileParser;
    private final Parsable productsParser;

    private ParserHandler() {
        discountCardParser = new DiscountCardParser();
        fileParser = new FileParser();
        productsParser = new ProductParser();
    }

    public Parsable getDiscountCardParser() {
        return discountCardParser;
    }

    public Parsable getFileParser() {
        return fileParser;
    }

    public Parsable getProductsParser() {
        return productsParser;
    }

    public static ParserHandler getInstance() {
        return instance;
    }
}

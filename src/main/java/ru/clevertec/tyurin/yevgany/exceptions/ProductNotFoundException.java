package ru.clevertec.tyurin.yevgany.exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}

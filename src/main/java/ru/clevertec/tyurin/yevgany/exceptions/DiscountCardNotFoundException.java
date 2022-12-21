package ru.clevertec.tyurin.yevgany.exceptions;

public class DiscountCardNotFoundException extends Exception{

    public DiscountCardNotFoundException(String message) {
        super(message);
    }

    public DiscountCardNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}
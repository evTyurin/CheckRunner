package ru.clevertec.tyurin.yevgany.exceptions;

public class DataException extends Exception{

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Exception exception) {
        super(message, exception);
    }
}

package ru.clevertec.tyurin.yevgany.exceptions;

public class FileReadingException extends Exception{

    public FileReadingException(String message) {
        super(message);
    }

    public FileReadingException(String message, Exception exception) {
        super(message, exception);
    }
}
package ru.clevertec.tyurin.yevgany;

import ru.clevertec.tyurin.yevgany.exceptions.DataException;
import ru.clevertec.tyurin.yevgany.exceptions.DiscountCardNotFoundException;
import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;
import ru.clevertec.tyurin.yevgany.exceptions.ProductNotFoundException;
import ru.clevertec.tyurin.yevgany.model.Check;
import ru.clevertec.tyurin.yevgany.service.CheckServiceImpl;
import ru.clevertec.tyurin.yevgany.service.CheckService;
import ru.clevertec.tyurin.yevgany.util.CheckWriter;
import ru.clevertec.tyurin.yevgany.util.ConsoleCheckWriter;
import ru.clevertec.tyurin.yevgany.util.FileCheckWriter;

public class Runner {
    public static void main(String[] args) throws ProductNotFoundException, DataException, FileReadingException, DiscountCardNotFoundException {
       CheckService checkService = new CheckServiceImpl();
       Check check = checkService.createCheck(args);
       CheckWriter fileCheckWriter = new FileCheckWriter(check);
       fileCheckWriter.write();
       CheckWriter consoleCheckWriter = new ConsoleCheckWriter(check);
       consoleCheckWriter.write();
    }
}
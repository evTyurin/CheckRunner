package ru.clevertec.tyurin.yevgany.service;

import ru.clevertec.tyurin.yevgany.exceptions.DataException;
import ru.clevertec.tyurin.yevgany.exceptions.DiscountCardNotFoundException;
import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;
import ru.clevertec.tyurin.yevgany.exceptions.ProductNotFoundException;
import ru.clevertec.tyurin.yevgany.model.Check;

public interface CheckService {
    Check createCheck(String[] arguments) throws FileReadingException, DiscountCardNotFoundException, DataException, ProductNotFoundException;
}

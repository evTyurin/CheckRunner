package ru.clevertec.tyurin.yevgany.dao;

import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;
import ru.clevertec.tyurin.yevgany.model.DiscountCard;
import ru.clevertec.tyurin.yevgany.model.Product;

import java.util.List;

public interface Loadable {
    List<Product> loadProducts(String fileName) throws FileReadingException;

    List<Product> getDefaultProducts();

    List<DiscountCard> loadDiscountCards(String fileName) throws FileReadingException;

    List<DiscountCard> getDefaultDiscountCards();
}
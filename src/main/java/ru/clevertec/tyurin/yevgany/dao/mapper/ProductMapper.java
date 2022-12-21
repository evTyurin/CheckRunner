package ru.clevertec.tyurin.yevgany.dao.mapper;

import ru.clevertec.tyurin.yevgany.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper implements Mappable<Product>{
    private static ProductMapper instance;

    ProductMapper() {}

    public static ProductMapper getInstance() {
        if (instance == null) {
            instance = new ProductMapper();
        }
        return instance;
    }

    @Override
    public List<Product> map(List<String[]> parsedProducts) {
        List<Product> products = new ArrayList<>();
        parsedProducts.forEach(parsedProduct -> products
                .add(new Product(Long.parseLong(parsedProduct[0].trim()),
                        parsedProduct[1].trim(),
                        Double.parseDouble(parsedProduct[2].trim()),
                        Boolean.parseBoolean(parsedProduct[3].trim()))));
        return products;
    }
}

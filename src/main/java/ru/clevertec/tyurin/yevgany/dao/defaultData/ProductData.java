package ru.clevertec.tyurin.yevgany.dao.defaultData;

import ru.clevertec.tyurin.yevgany.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private static ProductData instance;
    private List<Product> defaultProducts;

    ProductData() {
        defaultProducts = new ArrayList<>();
        defaultProducts.add(new Product(1,"bounty",1.99,true));
        defaultProducts.add(new Product(2,"mars",2.57,true));
        defaultProducts.add(new Product(3, "sneakers", 2.11, false));
    }

    public List<Product> getDefaultProducts() {
        return defaultProducts;
    }

    public static ProductData getInstance() {
        if (instance == null) {
            instance = new ProductData();
        }
        return instance;
    }
}
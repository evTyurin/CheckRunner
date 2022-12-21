package ru.clevertec.tyuriny.evgany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.clevertec.tyurin.yevgany.model.Check;
import ru.clevertec.tyurin.yevgany.model.DiscountCard;
import ru.clevertec.tyurin.yevgany.model.Product;
import ru.clevertec.tyurin.yevgany.service.CheckService;
import ru.clevertec.tyurin.yevgany.service.CheckServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CheckServiceTest {

    Map<Product,Integer> validProducts = new HashMap<>();
    Map<Product,Integer> invalidProducts = new HashMap<>();
    CheckService checkService = new CheckServiceImpl();
    String[] arguments = new String[4];
    DiscountCard validDiscountCard;
    DiscountCard invalidDiscountCard;

    @BeforeEach
    void setUp() throws Exception {
        validDiscountCard = new DiscountCard("1111", 0.01);
        invalidDiscountCard = new DiscountCard("7777", 0.99);
        validProducts.put(new Product(1,"bounty",1.99,true), 3);
        validProducts.put(new Product(2,"mars",2.57,true), 5);
        validProducts.put(new Product(3, "sneakers", 2.11, false), 10);
        invalidProducts.put(new Product(1,"bounty",1.99,true), 30);
        invalidProducts.put(new Product(2,"mars",2.57,true), 50);
        invalidProducts.put(new Product(3, "sneakers", 2.11, false), 80);
        arguments[0] = "1-3";
        arguments[1] = "2-5";
        arguments[2] = "3-10";
        arguments[3] = "card-1111";
    }

    @Test
    void testValidProductsCreateCheck() throws Exception {

        Check check = new Check.CheckBuilder().products(validProducts).build();
        assertEquals (check.getProducts(), checkService.createCheck(arguments).getProducts());
    }

    @Test
    void testInvalidProductsCreateCheck() throws Exception {

        Check check = new Check.CheckBuilder().products(invalidProducts).build();
        assertNotEquals (check.getProducts(), checkService.createCheck(arguments).getProducts());
    }

    @Test
    void testInvalidDiscountCardCreateCheck() throws Exception {

        Check check = new Check.CheckBuilder().discountCard(invalidDiscountCard).build();
        assertNotEquals (check.getDiscountCard(), checkService.createCheck(arguments).getDiscountCard());
    }
}

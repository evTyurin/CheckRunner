package ru.clevertec.tyurin.yevgany.util;


import ru.clevertec.tyurin.yevgany.model.Check;
import ru.clevertec.tyurin.yevgany.model.DiscountCard;
import ru.clevertec.tyurin.yevgany.model.Product;

import java.time.format.DateTimeFormatter;

public abstract class CheckWriter {

    public String createCheck(Check check) {
        String divider = "-----------------------------------------------------\n";
        DiscountCard discountCard = check.getDiscountCard();
        double total = 0;
        double cardDiscount = 0;
        StringBuilder checkBuilder = new StringBuilder();
        checkBuilder.append("                       CHECK" + "\n");
        checkBuilder.append("                                          ");
        checkBuilder.append(check.getPurchaseTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append("\n");
        checkBuilder.append("                                          ");
        checkBuilder.append(check.getPurchaseTime().format(DateTimeFormatter.ofPattern("HH:mm"))).append("\n");
        if (discountCard != null) {
            cardDiscount = discountCard.getDiscount();
            checkBuilder.append("Discount card: " + discountCard.getNumber() + "\n");
        }
        checkBuilder.append(divider);
        checkBuilder.append("                          Product   Card" + "\n");
        checkBuilder.append("Name       Price  Amount  discount  discount  Summary" + "\n");
        checkBuilder.append(divider);
        for (Product product:check.getProducts().keySet()) {
            int amount = check.getProducts().get(product);
            double productDiscountSum = (product.isDiscounted() && amount >= 5) ? Math.round(product.getPrice()*amount*0.1  * Math.pow(10, 2)) / Math.pow(10, 2) : 0;
            double cardDiscountSum = (discountCard != null) ? Math.round(product.getPrice()*amount*discountCard.getDiscount() * Math.pow(10, 2)) / Math.pow(10, 2) : 0;
            checkBuilder.append(product.getName() + " ".repeat(11 - product.getName().length())
                    + product.getPrice() + " ".repeat(9 - String.valueOf(product.getPrice()).length())
                    + amount + " ".repeat(7 - String.valueOf(amount).length())
                    + productDiscountSum + " ".repeat(10 - String.valueOf(productDiscountSum).length())
                    + cardDiscountSum + " ".repeat(10 - String.valueOf(cardDiscountSum).length() )
                    + (amount*product.getPrice()-productDiscountSum-cardDiscountSum)+ "\n");
            total += Math.round((amount*product.getPrice()-productDiscountSum-cardDiscountSum) * Math.pow(10, 2)) / Math.pow(10, 2);
        }
        checkBuilder.append(divider);
        checkBuilder.append("                                               " + total);
        return checkBuilder.toString();
    }

    public abstract void write();
}

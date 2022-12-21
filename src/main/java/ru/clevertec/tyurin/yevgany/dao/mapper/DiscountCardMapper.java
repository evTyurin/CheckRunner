package ru.clevertec.tyurin.yevgany.dao.mapper;

import ru.clevertec.tyurin.yevgany.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class DiscountCardMapper implements Mappable<DiscountCard>{

    private static DiscountCardMapper instance;

    DiscountCardMapper() {}

    public static DiscountCardMapper getInstance() {
        if (instance == null) {
            instance = new DiscountCardMapper();
        }
        return instance;
    }

    @Override
    public List<DiscountCard> map(List<String[]> parsedDiscountCards) {
        List<DiscountCard> discountCards = new ArrayList<>();
        parsedDiscountCards.forEach(parsedDiscountCard -> discountCards
                .add(new DiscountCard(parsedDiscountCard[0].trim(),
                        Double.parseDouble(parsedDiscountCard[1].trim()))));
        return discountCards;
    }
}

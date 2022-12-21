package ru.clevertec.tyurin.yevgany.dao.defaultData;

import ru.clevertec.tyurin.yevgany.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class DiscountCardData {
    private static DiscountCardData instance;
    private List<DiscountCard> defaultDiscountCards;

    DiscountCardData() {
        defaultDiscountCards = new ArrayList<>();
        defaultDiscountCards.add(new DiscountCard( "1111", 0.05));
        defaultDiscountCards.add(new DiscountCard("1112", 0.05));
        defaultDiscountCards.add(new DiscountCard( "1113", 0.05));
        defaultDiscountCards.add(new DiscountCard( "1211", 0.05));
        defaultDiscountCards.add(new DiscountCard( "1311", 0.05));
        defaultDiscountCards.add(new DiscountCard( "1411", 0.05));
        defaultDiscountCards.add(new DiscountCard( "1511", 0.05));
    }

    public List<DiscountCard> getDefaultDiscountCards() {
        return defaultDiscountCards;
    }

    public static DiscountCardData getInstance() {
        if (instance == null) {
            instance = new DiscountCardData();
        }
        return instance;
    }
}

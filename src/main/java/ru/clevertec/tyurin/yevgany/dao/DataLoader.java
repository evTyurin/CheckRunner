package ru.clevertec.tyurin.yevgany.dao;

import ru.clevertec.tyurin.yevgany.dao.defaultData.DiscountCardData;
import ru.clevertec.tyurin.yevgany.dao.defaultData.ProductData;
import ru.clevertec.tyurin.yevgany.dao.mapper.DiscountCardMapper;
import ru.clevertec.tyurin.yevgany.dao.mapper.Mappable;
import ru.clevertec.tyurin.yevgany.dao.mapper.ProductMapper;
import ru.clevertec.tyurin.yevgany.dao.parser.FileParser;
import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;
import ru.clevertec.tyurin.yevgany.model.DiscountCard;
import ru.clevertec.tyurin.yevgany.model.Product;

import java.util.List;

public class DataLoader implements Loadable {
    private static final DataLoader instance = new DataLoader();
    private final FileParser fileParser;

    private DataLoader() {
        this.fileParser = FileParser.getInstance();
    }

    @Override
    public List<Product> loadProducts(String fileName) throws FileReadingException {
        Mappable<Product> productMapper = ProductMapper.getInstance();
        return productMapper.map(fileParser.parseFile(fileName));
    }

    @Override
    public List<DiscountCard> loadDiscountCards(String fileName) throws FileReadingException {
        Mappable<DiscountCard> discountCardMapper = DiscountCardMapper.getInstance();
        return discountCardMapper.map(fileParser.parseFile(fileName));
    }

    @Override
    public List<DiscountCard> getDefaultDiscountCards() {
        return DiscountCardData.getInstance().getDefaultDiscountCards();
    }

    @Override
    public List<Product> getDefaultProducts() {
        return ProductData.getInstance().getDefaultProducts();
    }

    public static DataLoader getInstance() {
        return instance;
    }
}

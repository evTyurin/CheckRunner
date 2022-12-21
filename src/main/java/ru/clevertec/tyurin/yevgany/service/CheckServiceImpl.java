package ru.clevertec.tyurin.yevgany.service;

import ru.clevertec.tyurin.yevgany.argumentParser.ParserHandler;
import ru.clevertec.tyurin.yevgany.dao.DataLoader;
import ru.clevertec.tyurin.yevgany.dao.Loadable;
import ru.clevertec.tyurin.yevgany.exceptions.DataException;
import ru.clevertec.tyurin.yevgany.exceptions.DiscountCardNotFoundException;
import ru.clevertec.tyurin.yevgany.exceptions.FileReadingException;
import ru.clevertec.tyurin.yevgany.exceptions.ProductNotFoundException;
import ru.clevertec.tyurin.yevgany.model.Check;
import ru.clevertec.tyurin.yevgany.model.DiscountCard;
import ru.clevertec.tyurin.yevgany.model.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CheckServiceImpl implements CheckService {
    private String productsFile = "products.txt";
    private String discountCardFile = "discountCards.txt";
    private String keyValueSplitter = "-";
    private List<Product> products;
    private List<DiscountCard> discountCards;
    private DiscountCard discountCard;
    private Map<Product, Integer> productsWithQuantity;
    private Loadable loader;
    private ParserHandler parserHandler;

    public CheckServiceImpl() {
        productsWithQuantity = new HashMap<>();
        loader = DataLoader.getInstance();
        products = loader.getDefaultProducts();
        discountCards = loader.getDefaultDiscountCards();
        parserHandler = ParserHandler.getInstance();
    }

    @Override
    public Check createCheck(String[] files) throws FileReadingException, DiscountCardNotFoundException, DataException, ProductNotFoundException {
        List<String> filenames = parserHandler.getFileParser().parse(files);
        prepareData(filenames);
        List<String> cards = parserHandler.getDiscountCardParser().parse(files);
        if(!cards.isEmpty()){
            discountCard = getDiscountCard(cards);
        }
        List<String> products = parserHandler.getProductsParser().parse(files);
        if (!products.isEmpty()) {
            productsWithQuantity = getProductsWithQuantity(products);
        }
        return new Check.CheckBuilder()
                .purchaseTime(LocalDateTime.now())
                .discountCard(discountCard)
                .products(productsWithQuantity)
                .build();
    }

    private Map<Product, Integer> getProductsWithQuantity(List<String> productsWithQuantity) throws ProductNotFoundException {
        for (String productWithQuantity:productsWithQuantity) {
            String[] split = productWithQuantity.split(keyValueSplitter);
            int productNumber = Integer.parseInt(split[0]);
            int productAmount = Integer.parseInt(split[1]);
            Optional<Product> item = products
                    .stream()
                    .filter(product -> product.getId() == productNumber)
                    .findFirst();
            if(item.isPresent()) {
                Product product = item.get();
                if (this.productsWithQuantity.containsKey(product)) {
                    int oldValue = this.productsWithQuantity.get(product);
                    this.productsWithQuantity.replace(product, oldValue, oldValue + productAmount);
                } else {
                    this.productsWithQuantity.put(product,productAmount);
                }
            } else {
                throw new ProductNotFoundException("product " + productNumber + " not found");
            }
        }
        return this.productsWithQuantity;
    }

    private DiscountCard getDiscountCard(List<String> files) throws DataException, DiscountCardNotFoundException {
        if (files.size() == 1) {
            String discountCardNumber = files.get(0).split(keyValueSplitter)[1];
            Optional<DiscountCard> card = discountCards.stream().filter(dc -> dc
                    .getNumber()
                    .equals(discountCardNumber))
                    .findFirst();
            if(card.isPresent()) {
                discountCard = card.get();
                return discountCard;
            } else {
                throw new DiscountCardNotFoundException("card " + discountCardNumber + " not found");
            }
        }
        if (files.size() > 1) {
            throw new DataException("Exception! More then 1 card found");
        }
        return null;
    }

    private void prepareData(List<String> files) throws FileReadingException {
        for (String fileName:files) {
            if (fileName.equalsIgnoreCase(productsFile)) {
                products.addAll(loader.loadProducts(productsFile));
            } else if (fileName.equalsIgnoreCase(discountCardFile)) {
                discountCards.addAll(loader.loadDiscountCards(discountCardFile));
            } else {
                throw new IllegalArgumentException("file " + fileName + " not found!");
            }
        }
    }
}
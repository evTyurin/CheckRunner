package ru.clevertec.tyurin.yevgany.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Check {
    private DiscountCard discountCard;
    private Map<Product, Integer> products;
    private LocalDateTime purchaseTime;

    public Check(CheckBuilder builder) {
        this.discountCard = builder.discountCard;
        this.products = builder.products;
        this.purchaseTime = builder.purchaseTime;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public static class CheckBuilder {
        private DiscountCard discountCard;
        private Map<Product, Integer> products;
        private LocalDateTime purchaseTime;

        public CheckBuilder discountCard(DiscountCard discountCard) {
            this.discountCard = discountCard;
            return this;
        }

        public CheckBuilder products(Map<Product, Integer> products) {
            this.products = products;
            return this;
        }

        public CheckBuilder purchaseTime(LocalDateTime purchaseTime) {
            this.purchaseTime = purchaseTime;
            return this;
        }

        public Check build(){
            return new Check(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return getDiscountCard().equals(check.getDiscountCard()) && getProducts().equals(check.getProducts()) && getPurchaseTime().equals(check.getPurchaseTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountCard(), getProducts(), getPurchaseTime());
    }
}

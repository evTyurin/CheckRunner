package ru.clevertec.tyurin.yevgany.model;

import java.util.Objects;

public class DiscountCard {
    private String number;
    private double discount;

    public DiscountCard(String number, double discount) {
        this.number = number;
        this.discount = discount;
    }

    public String getNumber() {
        return number;
    }

    public double getDiscount() {
        return discount;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountCard)) return false;
        DiscountCard that = (DiscountCard) o;
        return Double.compare(that.getDiscount(), getDiscount()) == 0 && getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getDiscount());
    }
}

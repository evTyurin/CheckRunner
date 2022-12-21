package ru.clevertec.tyurin.yevgany.model;

import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private double price;
    private boolean isDiscounted;

    public Product(long id, String name, double price, boolean isDiscounted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscounted = isDiscounted;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() && Double.compare(product.getPrice(), getPrice()) == 0 && isDiscounted() == product.isDiscounted() && getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), isDiscounted());
    }
}

package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public abstract double getProductPrice();

    public abstract boolean isSpecial();

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}

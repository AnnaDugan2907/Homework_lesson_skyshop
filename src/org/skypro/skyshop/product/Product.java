package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;

        if(productName == null | productName.isBlank()){
            throw new IllegalArgumentException(new StringBuilder("Название продукта не может быть пустым").toString());
        }
    }

    public abstract double getProductPrice();

    public abstract boolean isSpecial();

    public String getProductName() {
        return productName;
    }

    @Override
    public String getName() {
        return getProductName();
    }

    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return new StringBuilder(productName).toString();
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

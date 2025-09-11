package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {

    private final double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        super(productName);
        this.productPrice = productPrice;

        if (productPrice <= 0){
            throw new IllegalArgumentException(new StringBuilder("Цена не может быть меньше или равна нулю").toString());
        }
    }


    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Double.compare(that.productPrice, productPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productPrice);
    }
}

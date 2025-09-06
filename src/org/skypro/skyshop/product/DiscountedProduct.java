package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {

    private final double productPrice;
    private final int discount;

    public DiscountedProduct(String productName, double productPrice, int discount) {
        super(productName);
        this.productPrice = productPrice;
        this.discount = discount;
    }

    private double calculatorDiscount() {
        double discountAmount = productPrice * (discount / 100.0);
        return productPrice - discountAmount;
    }

    @Override
    public double getProductPrice() {
        return calculatorDiscount();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getProductName() + " со скидкой: " + getProductPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(that.productPrice, productPrice) == 0 && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productPrice, discount);
    }

}

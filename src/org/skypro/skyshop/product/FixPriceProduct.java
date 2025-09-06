package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final double FIX_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    public String toString() {
        return getProductName() + ": Фиксированная цена " + FIX_PRICE;
    }


    @Override
    public double getProductPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

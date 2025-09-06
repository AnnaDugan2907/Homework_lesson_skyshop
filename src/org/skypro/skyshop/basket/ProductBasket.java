package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.List;

public class ProductBasket {
    private static Product[] products = new Product[5];

//    public void printall() {
//        for (int i = 0; i < products.length; i++) {
//            System.out.println(products[i].getProductName() + ": " + products[i].getProductPrice());
//        }
//    }

    public void setProduct(Product product) {

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int basketTotalSum() {

        int basketSum = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                basketSum += products[i].getProductPrice();
            }
        }

        return basketSum;
    }

    public void basketPrinting() {

        boolean a = true;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null){
                System.out.println(products[i].getProductName() + ": " + products[i].getProductPrice());
                a = false;
            }
        }

        if (a) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + basketTotalSum());
        }
    }

    public boolean containsProduct(String productName) {

        boolean b = false;

        for (Product product : products) {
            if (product != null && product.getProductName().equalsIgnoreCase(productName)) {
                b = true;
            }
        }

        if (b == true) {
            System.out.println("Есть ли " + productName + " в корзине? " + "да");
        } else {
            System.out.println("Есть ли " + productName + " в корзине? " + "нет");
        }
        return b;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

}

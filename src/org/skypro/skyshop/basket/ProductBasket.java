package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> productsMap = new HashMap<>();

    public void setProduct(Product product) {
        String name = product.getProductName();
        productsMap.putIfAbsent(name, new ArrayList<>());
        productsMap.get(name).add(product);
    }

    public List<Product> deletingAProductByName(String name) {
        return productsMap.remove(name);
    }

    public int basketTotalSum() {
        int basketSum = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product != null) {
                    basketSum += product.getProductPrice();
                }
            }
        }
        return basketSum;
    }

    public void basketPrinting() {

        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;

        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            String productName = entry.getKey();
            List<Product> productList = entry.getValue();

            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + basketTotalSum());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        boolean b = false;
        for (String key : productsMap.keySet()) {
            if (key.equalsIgnoreCase(productName)) {
                b = true;
                break;
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
        productsMap.clear();
    }

}

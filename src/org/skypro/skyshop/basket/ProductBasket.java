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

    public double basketTotalSum() {
        double total = productsMap.values().stream().flatMap(Collection::stream)
                .mapToDouble(x -> x.getProductPrice())
                .sum();
        return total;
    }

    public void basketPrinting() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product));

        int specialCount = getSpecialCount();

        System.out.println("Итого: " + basketTotalSum());
        System.out.println("Специальных товаров: " + specialCount);
    }

    private int getSpecialCount() {
        return (int) productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean containsProduct(String productName) {
        boolean exists = productsMap.keySet().stream()
                .anyMatch(key -> key.equalsIgnoreCase(productName));

        System.out.println("Есть ли " + productName + " в корзине? " + (exists ? "да" : "нет"));

        return exists;
    }


    public void clear() {
        productsMap.clear();
    }
}

package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private static  List<Product> products = new LinkedList<>();

    public void setProduct(Product product) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                products.set(i, product);
                return;
            }
        }
        products.add(product);
    }

    public List<Product> deletingAProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getProductName().equalsIgnoreCase(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

    public int basketTotalSum() {

        int basketSum = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null) {
                basketSum += products.get(i).getProductPrice();
            }
        }

        return basketSum;
    }

    public void basketPrinting() {

        int specialCount = 0;

        boolean a = true;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null) {

                System.out.println(products.get(i).toString());

                if (products.get(i).isSpecial())  {
                    specialCount++;
                }

                a = false;
            }
        }

        if (a) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + basketTotalSum());

            System.out.println("Специальных товаров: " + specialCount);
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
        for (int i = 0; i < products.size(); i++) {
            products.clear();
        }
    }

}

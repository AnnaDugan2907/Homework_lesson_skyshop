package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();

        System.out.println(" ");

        //Вывод корзины
        productBasket.basketPrinting();

        //Стоимость всей корзины
        productBasket.basketTotalSum();

        System.out.println(" ");

        //Поиск товара в корзине
        productBasket.containsProduct("Хлеб");
        productBasket.containsProduct("Торт");

        System.out.println(" ");

        //Очистка корзины
        productBasket.clear();

        System.out.println("Стоимость корзины после очистки " + productBasket.basketTotalSum());

        System.out.println(" ");
        //Вывод корзины
        productBasket.basketPrinting();

        System.out.println(" ");

        //Поиск товара в пустой корзине
        productBasket.containsProduct("Хлеб");

        System.out.println("\nSearch");

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(new SimpleProduct("Хлеб", 45));
        searchEngine.add(new FixPriceProduct("Молоко"));
        searchEngine.add(new SimpleProduct("Мороженое", 56));
        searchEngine.add(new DiscountedProduct("Мясо", 450, 15));
        searchEngine.add(new SimpleProduct("Масло", 155));
        searchEngine.add(new SimpleProduct("Торт", 565));

        // Статьи
        searchEngine.add(new Article("Туризм и приключения", "Лучшие направления для активного отдыха."));
        searchEngine.add(new Article("Тенденции моды 2024", "Обзор последних трендов в мире моды этого года."));
        searchEngine.add(new Article("Лучшие фильмы 2024 года", "Обзор самых ожидаемых кинопремьер."));
        searchEngine.add(new Article("Психология счастья", "Советы и научные исследования о том, как стать счастливее."));
        searchEngine.add(new Article("Обзор новых технологий в автомобилестроении", "Инновации и тренды в автопроме."));

        // Поиск
        List<String> search = new ArrayList<>();
        search.add("Психология");
        search.add("Мороженое");
        search.add("моды");
        search.add("Мясо");
        search.add("фильмы");
        search.add("Обзор");

        String[] searches = search.toArray(new String[0]);

        for (int i = 0; i < searches.length; i++) {
            String query = searches[i];
            System.out.println(" ");
            Searchable[] results = searchEngine.search(query);
            for (int j = 0; j < results.length; j++) {
                if (results[j] != null) {
                    System.out.println(results[j].getStringRepresentation());
                }
            }
        }
    }



    //Заполнение корзины
    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();

        productBasket.setProduct(new SimpleProduct("Хлеб", 45));
        productBasket.setProduct(new FixPriceProduct("Молоко"));
        productBasket.setProduct(new SimpleProduct("Мороженое", 56));
        productBasket.setProduct(new DiscountedProduct("Мясо", 450, 15));
        productBasket.setProduct(new SimpleProduct("Масло", 155));

        productBasket.setProduct(new SimpleProduct("Торт", 565)); //Выводится сообщение "Невозможно добавить продукт"

        return productBasket;
    }

}
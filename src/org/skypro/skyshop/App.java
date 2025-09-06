package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();

        System.out.println(" ");

        //Вывод корзины
        //productBasket.printall();
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


    }

    //Заполнение корзины
    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();

        productBasket.setProduct(new Product("Хлеб", 45));
        productBasket.setProduct(new Product("Молоко", 143));
        productBasket.setProduct(new Product("Мороженое", 56));
        productBasket.setProduct(new Product("Мясо", 450));
        productBasket.setProduct(new Product("Масло", 155));

        productBasket.setProduct(new Product("Торт", 565)); //Выводится сообщение "Невозможно добавить продукт"

        return productBasket;
    }

}
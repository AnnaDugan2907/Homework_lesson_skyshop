package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

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


    }

    //Заполнение корзины
    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();

        productBasket.setProduct(new SimpleProduct("Хлеб", 45));
        productBasket.setProduct(new FixPriceProduct("Молоко"));
        productBasket.setProduct(new SimpleProduct("Мороженое", 56));
        productBasket.setProduct(new DiscountedProduct("Мясо", 450,15));
        productBasket.setProduct(new SimpleProduct("Масло", 155));

        productBasket.setProduct(new SimpleProduct("Торт", 565)); //Выводится сообщение "Невозможно добавить продукт"

        return productBasket;
    }

}
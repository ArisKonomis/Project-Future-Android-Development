package gr.company.training;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        float totalPrice;
//        totalPrice = calculation(12, 1.3f );
//        System.out.println("Total Price = " + totalPrice);

        Product product = new Product("A1", "Apple", 1, 50);
        Product product2 = new Product("A2", "Mouse", 10, 5);

        Basket basket = new Basket();
        basket.addProduct(product);
        basket.addProduct(product2);

        basket.displayProducts();
        System.out.println(basket.getTotalCost());

        basket.removeProduct(1);
        basket.displayProducts();
        System.out.println(basket.getTotalCost());




    }

    public static float calculation(int quantity, float price){
        float totalPrice;
        float tax = 1.1f;
        totalPrice = (quantity * price) + tax;
        return totalPrice;
    }
}

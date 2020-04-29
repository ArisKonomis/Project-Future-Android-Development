package gr.company.training;

import org.w3c.dom.ls.LSOutput;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int index){
        if( index < products.size() && index >= 0){
            products.remove(index);
        }

    }

    public void clearProducts(){
        products.clear();
    }

    public void displayProducts(){
        //Lamda calculus
        //products.forEach( product -> System.out.println(product));
        products.forEach( System.out::println );
    }

    public float getTotalCost(){

//        float totalProductsPrice = 0;
//        for (Product p : products){
//            totalProductsPrice += p.getPrice() * p.getQuantity();
//        }

        //Lamda
        float totalProductsPrice = 0;
        totalProductsPrice = products.stream()
                .map(p -> p.getPrice()*p.getQuantity())
                .reduce(0.0f, (a,b) -> a+b);

        return totalProductsPrice;
    }
}

package gr.company.training;

import org.w3c.dom.ls.LSOutput;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
        float totalProductsPrice;
        totalProductsPrice = products.stream()
                .map(p -> p.getPrice()*p.getQuantity())
                .reduce(0.0f, (a,b) -> a+b);

        return totalProductsPrice;
    }

    public void saveBasket(String filename){
        try{
            PrintWriter printwriter = new PrintWriter(new File(filename));
            for (Product p : products){
                printwriter.println(p.getCode() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity());
            }
            printwriter.close();
        }
        catch(FileNotFoundException e){
            System.out.println("The file cannot be saved");
        }
    }

    public void loadBasket(String filename){
        products.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Product product = new Product(words[0], words[1], Float.parseFloat(words[2]), Integer.parseInt(words[3]));
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

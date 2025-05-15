package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= numberOfProducts; i++){
            System.out.printf("Product #%d data:%n",i);
            System.out.println("Comom, used or imported (c/u/i)?");
            char tag = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            if(tag == 'i'){
                System.out.print("Custom fee: ");
                double customFee = sc.nextDouble();
                sc.nextLine();
                Product product = new ImportedProduct(name, price, customFee);
                products.add(product);
            } else if(tag == 'u'){
                System.out.print("Manufacture Date: ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                sc.nextLine();
                Product product = new UsedProduct(name,price, manufactureDate);
                products.add(product);
            } else {
                Product product = new Product(name,price);
                products.add(product);
            }
        }

        for(Product p: products){
            System.out.println(p.priceTag());
        }


        sc.close();
    }
}

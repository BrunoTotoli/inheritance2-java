package program;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        List<Product> productList = new ArrayList<>();
        System.out.println("Enter the number of products: ");
        int numberOfProducts = in.nextInt();
        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.println("Common, used or imported (c/u/i)");
            String type = in.next();
            type.toLowerCase();
            System.out.println("Name: ");
            String name = in.next();
            System.out.println("Price: ");
            Double price = in.nextDouble();
            if (type.equals("c")) {
                Product p = new Product(name, price);
                productList.add(p);
            } else if (type.equals("u")) {
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                String dateString = in.next();
                try {
                    UsedProduct usedProduct = new UsedProduct(name, price, sdf.parse(dateString));
                    productList.add(usedProduct);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (type.equals("i")) {
                System.out.println("Customs fee: ");
                Double fee = in.nextDouble();
                ImportedProduct importedProduct = new ImportedProduct(name, price, fee);
                productList.add(importedProduct);
            } else {
                System.out.println("Invalid type");
            }

        }
        System.out.println("Price Tags: ");
        for (Product a : productList) {
            System.out.println(a.priceTag());
        }


    }
}

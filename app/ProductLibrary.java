package app;

import java.util.ArrayList;
import java.util.List;

public class ProductLibrary {
    public static List<Product> products = new ArrayList<>();
        static {
            products.add(new Product(1001, "Hair Mousse", "Lola Ltd", 150, 40.00));
            products.add(new Product(1002, "Shampoo", "Carriers Ltd", 250, 15.00));
            products.add(new Product(1003, "Conditioner", "The Hair Supplier", 100, 12.00));
            products.add(new Product(1004, "Aftercare", "Hair for Us", 50, 20.00));
            products.add(new Product(1005, "Butter Hair treatment", "new Wave", 150, 22.50));
        }

        //finding a product by name
        public static Product getProductByName(String name) {
            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null;
        }

        //printing all available products
        public static void printAvailableProducts() {
            System.out.println("Available Products:");
            for (Product product : products) {
                System.out.println("- " + product.getProductName());
            }
            
        }

        //Returning all products (if needed)
        public static List<Product> getAllProducts() {
            return products;
        }

    }










    
    

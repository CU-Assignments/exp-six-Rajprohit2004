import java.util.*;
import java.util.stream.*;

public class ProductProcessing {

    // Product class definition
    static class Product {
        private String name;
        private String category;
        private double price;

        // Constructor
        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
        }
    }

    // Main method to process products
    public static void main(String[] args) {

        // List of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Smartphone", "Electronics", 800.00));
        products.add(new Product("Washing Machine", "Home Appliances", 600.00));
        products.add(new Product("Air Conditioner", "Home Appliances", 1500.00));
        products.add(new Product("Refrigerator", "Home Appliances", 1000.00));
        products.add(new Product("Headphones", "Electronics", 150.00));
        products.add(new Product("Blender", "Home Appliances", 90.00));

        // 1. Group products by category
        System.out.println("Grouped products by category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Find the most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveProduct = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        mostExpensiveProduct.forEach((category, product) -> {
            product.ifPresent(p -> System.out.println(category + ": " + p));
        });

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}


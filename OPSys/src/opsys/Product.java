package opsys;

public class Product {

    private String name; // The name of the product
    private double price; // The price of the product

    // Constructor to initialize product with name and price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter method for product name
    public String getName() {
        return name;
    }

    // Setter method for product name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for product price
    public double getPrice() {
        return price;
    }

    // Setter method for product price
    public void setPrice(double price) {
        this.price = price;
    }
}
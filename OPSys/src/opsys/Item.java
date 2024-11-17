package opsys;

// Item class extends Product and adds quantity to represent the item being ordered.
public class Item extends Product {

    private int quantity; // The quantity of the item in stock

    // Constructor to initialize item with name, price, and quantity
    public Item(String name, int quantity, double price) {
        super(name, price); // Call the Product constructor to initialize name and price
        this.quantity = quantity; // Set the quantity of the item
    }

    // Getter method for item quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter method for item quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


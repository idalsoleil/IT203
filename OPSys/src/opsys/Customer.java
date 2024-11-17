package opsys;

public class Customer {

    private String customerName; // The name of the customer

    // Constructor to initialize customer with a name
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    // Getter method for customer's name
    public String getCustomerName() {
        return customerName;
    }

    // Setter method for customer's name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}


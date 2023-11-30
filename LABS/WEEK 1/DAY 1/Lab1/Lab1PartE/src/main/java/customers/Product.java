package customers;

public class Product {
    private String name;
    private double price;

    private Customer customer;

    public Product(String name, double price, Customer customer) {
        this.name = name;
        this.price = price;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
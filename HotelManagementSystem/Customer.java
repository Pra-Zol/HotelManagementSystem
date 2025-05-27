// Customer.java
public class Customer {
    private String name;
    private double discount;
    private String status; // Status of the customer ("Active", "VIP", "New")

    // Default constructor
    public Customer() {
        this.name = "Unknown";
        this.discount = 0.0; // Default discount is 0%
        this.status = "New"; // Default status is "New"
    }

    // Parameterized constructor
    public Customer(String name, String status) {
        this.name = name;
        this.status = status;
        setDiscount(status); // Calculate discount based on status
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(String status) {
        if (status.equalsIgnoreCase("Active")) {
            this.discount = 8.0; // 8% discount for Active customers
        } else if (status.equalsIgnoreCase("VIP")) {
            this.discount = 12.0; // 12% discount for VIP customers
        } else {
            this.discount = 0.0; // No discount for New customers
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setDiscount(status);
    }

    // toString() method to return relevant data for the customer
    @Override
    public String toString() {
        return "Customer Name: " + name + "\n"
                + "Status: " + status + "\n"
                + "Discount: " + discount + "%";
    }
}

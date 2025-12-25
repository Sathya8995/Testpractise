package org.example.SolidPrinciples;

public class ProductBeforeSRP {
    private String name;
    private double price;

    public ProductBeforeSRP(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void saveProduct() {
        // Logic to save product to the database
        System.out.println("Product saved to database");
    }

    public void generateInvoice() {
        // Logic to generate invoice
        System.out.println("Invoice generated for product: " + name);
    }
}

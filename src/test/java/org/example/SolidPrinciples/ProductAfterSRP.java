package org.example.SolidPrinciples;

public class ProductAfterSRP {
    private String name;
    private double price;

    public ProductAfterSRP(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// ProductRepository.java
class ProductRepository {
    public void saveProduct(ProductAfterSRP product) {
        // Logic to save product to the database
        System.out.println("Product saved to database");
    }
}

// InvoiceGenerator.java
class InvoiceGenerator {
    public void generateInvoice(ProductAfterSRP product) {
        // Logic to generate invoice
        System.out.println("Invoice generated for product: " +
                product.getName());
    }
}

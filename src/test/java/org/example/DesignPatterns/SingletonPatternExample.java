package org.example.DesignPatterns;

// Enum Singleton
enum EnumSingleton {
    INSTANCE;

    // Singleton-specific methods can be added here
    public void showMessage() {
        System.out.println("Hello from EnumSingleton!");
    }
    //It is thread-safe by default, provides a guard against reflection attacks, and handles serialization automatically.
}

//The Best Lazy Implementation: Bill Pugh Holder
class BillSingleton {
    private BillSingleton() {}

    private static class Holder {
        private static final BillSingleton INSTANCE = new BillSingleton();
    }

    public static BillSingleton getInstance() {
        return Holder.INSTANCE;
    }

    // Singleton-specific methods can be added here
    public void showMessage() {
        System.out.println("Hello from BillSingleton!");
    }

}

// Main class to test the Singleton pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the singleton instance
        EnumSingleton enumsingleton1 = EnumSingleton.INSTANCE;

        // Call the method
        enumsingleton1.showMessage(); // Output: Hello from Singleton!

        // Get the singleton instance again
        EnumSingleton enumsingleton2 = EnumSingleton.INSTANCE;

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (enumsingleton1 == enumsingleton2)); // Output: Are both instances the same? true

        // Get the singleton instance
        BillSingleton billSingleton1 = BillSingleton.getInstance();
        // Call the method
        billSingleton1.showMessage();

        // Get the singleton instance again
        BillSingleton billSingleton2 = BillSingleton.getInstance();

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (enumsingleton1 == enumsingleton2)); // Output: Are both instances the same? true
    }
}


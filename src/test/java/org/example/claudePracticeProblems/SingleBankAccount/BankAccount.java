package org.example.claudePracticeProblems.SingleBankAccount;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        System.out.println("Deposited: $" + String.format("%.2f", amount));
    }

    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if(balance < amount){
            throw new IllegalArgumentException("Insufficient balance. Available: $"
                    + String.format("%.2f", balance));
        }
        this.balance -= amount;
        System.out.println("Withdrew: $" + String.format("%.2f", amount));
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount{balance=$%.2f}", balance);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("=== Bank Account Demo ===\n");

        BankAccount acc = new BankAccount(10000);
        System.out.println("Initial: " + acc);

        acc.deposit(5000);
        System.out.println("After deposit: " + acc);

        acc.withdraw(8000);
        System.out.println("After withdrawal: " + acc);

        // Test edge cases
        System.out.println("\n--- Testing Edge Cases ---");
        try {
            acc.withdraw(20000); // Should fail
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            acc.deposit(-100); // Should fail
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
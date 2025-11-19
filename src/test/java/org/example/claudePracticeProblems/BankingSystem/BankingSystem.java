package org.example.claudePracticeProblems.BankingSystem;

import java.util.List;

public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("=== Banking System Demo ===\n");

        // Create a bank
        Bank bank = new Bank("JavaBank");

        // Create different types of accounts
        SavingsAccount savings1 = new SavingsAccount("SAV001", "Alice Johnson", 5000);
        CheckingAccount checking1 = new CheckingAccount("CHK001", "Bob Smith", 2000, true);
        SavingsAccount savings2 = new SavingsAccount("SAV002", "Alice Johnson", 10000);
        CheckingAccount checking2 = new CheckingAccount("CHK002", "Charlie Brown", 1500, false);

        // Add accounts to bank
        bank.addAccount(savings1);
        bank.addAccount(checking1);
        bank.addAccount(savings2);
        bank.addAccount(checking2);

        // Display all accounts
        bank.displayAllAccounts();

        // Demonstrate polymorphism with deposits
        System.out.println("\n=== Testing Deposits ===");
        savings1.deposit(1000);
        checking1.deposit(500);

        // Demonstrate different withdrawal behaviors
        System.out.println("\n=== Testing Withdrawals ===");
        savings1.withdraw(800);
        savings1.withdraw(1200); // Should fail - exceeds limit

        checking1.withdraw(2300); // Should succeed with overdraft
        checking2.withdraw(2000); // Should fail - no overdraft protection

        // Test equals and hashCode
        System.out.println("\n=== Testing equals() and hashCode() ===");
        Account testAccount = new SavingsAccount("SAV001", "Test User", 1000);
        System.out.println("savings1.equals(testAccount): " + savings1.equals(testAccount));
        System.out.println("savings1.hashCode() == testAccount.hashCode(): " +
                (savings1.hashCode() == testAccount.hashCode()));

        // Apply monthly interest - demonstrates polymorphism
        bank.applyMonthlyInterest();

        // Find accounts by owner
        System.out.println("\n=== Accounts for Alice Johnson ===");
        List<Account> aliceAccounts = bank.getAccountsByOwner("Alice Johnson");
        for (Account account : aliceAccounts) {
            System.out.println(account);
        }

        // Display total balance
        System.out.println("\n=== Bank Summary ===");
        System.out.println("Total Balance in Bank: $" +
                String.format("%.2f", bank.getTotalBalance()));

        // Final account display
        bank.displayAllAccounts();
    }
}

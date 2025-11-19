package org.example.claudePracticeProblems.BankingSystem;

// Account.java - Abstract base class

import java.util.Objects;
import java.util.*;

public abstract class Account {

    private final String accountNumber;
    private double balance;
    private final String owner;

    // Constructor
    public Account(String accountNumber, String owner, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    // Protected setter for balance (only subclasses can modify)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Common deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
    }

    // Abstract withdraw method - each account type implements its own rules
    public abstract boolean withdraw(double amount);

    // Abstract method to calculate interest
    public abstract void applyInterest();

    // Override equals - two accounts are equal if they have the same account number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    // Override hashCode - must override when equals is overridden
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return String.format("%s [Account: %s, Owner: %s, Balance: $%.2f]",
                getClass().getSimpleName(), accountNumber, owner, balance);
    }
}

// SavingsAccount.java
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03; // 3% annual interest
    private static final double WITHDRAWAL_LIMIT = 1000.0;
    private int withdrawalsThisMonth;
    private static final int MAX_WITHDRAWALS_PER_MONTH = 6;

    public SavingsAccount(String accountNumber, String owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
        this.withdrawalsThisMonth = 0;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }

        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds limit of $" + WITHDRAWAL_LIMIT);
            return false;
        }

        if (withdrawalsThisMonth >= MAX_WITHDRAWALS_PER_MONTH) {
            System.out.println("Monthly withdrawal limit reached (" + MAX_WITHDRAWALS_PER_MONTH + " withdrawals)");
            return false;
        }

        if (amount > getBalance()) {
            System.out.println("Insufficient funds. Balance: $" + getBalance());
            return false;
        }

        setBalance(getBalance() - amount);
        withdrawalsThisMonth++;
        System.out.println("Withdrawn: $" + amount + " | New Balance: $" + getBalance());
        return true;
    }

    @Override
    public void applyInterest() {
        double interest = getBalance() * INTEREST_RATE / 12; // Monthly interest
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: $" + String.format("%.2f", interest) +
                " | New Balance: $" + String.format("%.2f", getBalance()));
    }

    public void resetMonthlyWithdrawals() {
        withdrawalsThisMonth = 0;
        System.out.println("Monthly withdrawal counter reset for account: " + getAccountNumber());
    }

    public int getWithdrawalsThisMonth() {
        return withdrawalsThisMonth;
    }
}

// CheckingAccount.java
class CheckingAccount extends Account {
    private static final double INTEREST_RATE = 0.01; // 1% annual interest
    private static final double OVERDRAFT_LIMIT = 500.0;
    private static final double OVERDRAFT_FEE = 35.0;
    private boolean hasOverdraftProtection;

    public CheckingAccount(String accountNumber, String owner, double initialBalance,
                           boolean hasOverdraftProtection) {
        super(accountNumber, owner, initialBalance);
        this.hasOverdraftProtection = hasOverdraftProtection;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }

        double availableBalance = getBalance();
        if (hasOverdraftProtection) {
            availableBalance += OVERDRAFT_LIMIT;
        }

        if (amount > availableBalance) {
            System.out.println("Insufficient funds. Available: $" + availableBalance);
            return false;
        }

        setBalance(getBalance() - amount);

        // Apply overdraft fee if balance goes negative
        if (getBalance() < 0 && hasOverdraftProtection) {
            setBalance(getBalance() - OVERDRAFT_FEE);
            System.out.println("Overdraft fee applied: $" + OVERDRAFT_FEE);
        }

        System.out.println("Withdrawn: $" + amount + " | New Balance: $" + getBalance());
        return true;
    }

    @Override
    public void applyInterest() {
        // Only apply interest if balance is positive
        if (getBalance() > 0) {
            double interest = getBalance() * INTEREST_RATE / 12; // Monthly interest
            setBalance(getBalance() + interest);
            System.out.println("Interest applied: $" + String.format("%.2f", interest) +
                    " | New Balance: $" + String.format("%.2f", getBalance()));
        } else {
            System.out.println("No interest applied (negative balance)");
        }
    }

    public boolean hasOverdraftProtection() {
        return hasOverdraftProtection;
    }

    public void setOverdraftProtection(boolean hasOverdraftProtection) {
        this.hasOverdraftProtection = hasOverdraftProtection;
        System.out.println("Overdraft protection " +
                (hasOverdraftProtection ? "enabled" : "disabled") +
                " for account: " + getAccountNumber());
    }
}

// Bank.java - Demonstrates polymorphism


class Bank {
    private final String bankName;
    private final List<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        if (accounts.contains(account)) {
            System.out.println("Account already exists: " + account.getAccountNumber());
            return;
        }
        accounts.add(account);
        System.out.println("Account added successfully: " + account.getAccountNumber());
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("\n=== " + bankName + " - All Accounts ===");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    // Demonstrates polymorphism - applies interest to all accounts
    public void applyMonthlyInterest() {
        System.out.println("\n=== Applying Monthly Interest ===");
        for (Account account : accounts) {
            account.applyInterest(); // Polymorphic call
        }
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public List<Account> getAccountsByOwner(String owner) {
        List<Account> ownerAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getOwner().equalsIgnoreCase(owner)) {
                ownerAccounts.add(account);
            }
        }
        return ownerAccounts;
    }
}
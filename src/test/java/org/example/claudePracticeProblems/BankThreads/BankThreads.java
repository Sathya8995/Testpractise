package org.example.claudePracticeProblems.BankThreads;

public class BankThreads {
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount();
        Runnable ob1 = () -> {
            for (int i=0; i<1000; i++)
                ba.withdraw(1000);
        };

        Runnable ob2 = () -> {
            for (int i=0; i<1000; i++)
                ba.deposit(1000);
        };

        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Balance: "+ba.getBalance());
        System.out.println("Total Transactions: "+ba.getCount());
    }
}

class BankAccount {
    private float balance = 100f;
    private int count =0;

    public synchronized void count(){
        count++;
    }
    public synchronized void withdraw(float amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        while(balance < amount) {
            System.out.println("Insufficient balance, waiting...");
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        this.balance -= amount;
        System.out.println("Withdrew: $" + String.format("%.2f", amount));
        count();

        notifyAll(); // Notify waiting threads

    }
    public synchronized void deposit(float amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        this.balance += amount;
        System.out.println("Deposited: $" + String.format("%.2f", amount));
        count();

        notifyAll(); // Notify waiting threads
    }

    public synchronized float getBalance() {
        return balance;
    }

    public synchronized int getCount() {
        return count;
    }
}

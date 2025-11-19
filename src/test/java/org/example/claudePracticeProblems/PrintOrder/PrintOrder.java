package org.example.claudePracticeProblems.PrintOrder;

public class PrintOrder {
    public static void main(String[] args) throws InterruptedException {

        // Part 1: Show the problem (WITHOUT synchronization)
        System.out.println("=== WITHOUT Synchronization (Problem) ===");
        testUnsynchronized();

        // Part 2: Show the solution (WITH synchronization)
        System.out.println("\n=== WITH Synchronization (Solution) ===");
        testSynchronized();
    }

    // ❌ WITHOUT synchronization - shows the problem
    private static void testUnsynchronized() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> System.out.print("Hello "));
            Thread t2 = new Thread(() -> System.out.println("World"));

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    // ✅ WITH synchronization - shows the solution
    private static void testSynchronized() throws InterruptedException {
        Printer printer = new Printer();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printer.printHello();
            }
        }, "Hello-Thread");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printer.printWorld();
            }
        }, "World-Thread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

// Synchronized printer using wait/notify
class Printer {
    private boolean helloTurn = true; // Flag to control turn

    public synchronized void printHello() {
        // Wait until it's our turn
        while (!helloTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.print("Hello ");
        helloTurn = false; // Give turn to World
        notifyAll(); // Wake up World thread
    }

    public synchronized void printWorld() {
        // Wait until it's our turn
        while (helloTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("World");
        helloTurn = true; // Give turn back to Hello
        notifyAll(); // Wake up Hello thread
    }
}

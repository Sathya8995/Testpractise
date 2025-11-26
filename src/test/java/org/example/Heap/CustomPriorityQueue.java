package org.example.Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomPriorityQueue {

    /**
     * Custom Comparator: Even numbers have higher priority (are treated as "smaller").
     */
    private static class EvenHighPriorityComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {

            boolean aIsEven = (a % 2 == 0);
            boolean bIsEven = (b % 2 == 0);

            // --- Case 1: Both are even ---
            // If both are even, use natural order (standard Min-Heap behavior: smaller number comes first).
            if (aIsEven && bIsEven) {
                return a.compareTo(b);
            }

            // --- Case 2: A is even, B is odd (A has higher priority) ---
            // A should come before B. Return a negative value.
            if (aIsEven) {
                return -1;
            }

            // --- Case 3: A is odd, B is even (B has higher priority) ---
            // B should come before A. Return a positive value.
            if (bIsEven) {
                return 1;
            }

            // --- Case 4: Both are odd ---
            // If both are odd, use natural order (standard Min-Heap behavior: smaller number comes first).
            return a.compareTo(b);
        }
    }

    public static void main(String[] args) {
        // Initialize the PriorityQueue with the custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(new EvenHighPriorityComparator());

        // Insert elements (mix of even and odd)
        pq.offer(15);
        pq.offer(8);
        pq.offer(2);
        pq.offer(11);
        pq.offer(4);
        pq.offer(17);
        pq.offer(1);

        System.out.println("PriorityQueue contents after insertion:");
        System.out.println(pq); // The internal array representation (not guaranteed output order)

        System.out.println("\nRemoving elements (highest priority first):");

        // Dequeue elements until the queue is empty
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll());
        }

        /*
        Expected Output Order:
        1. All evens, sorted naturally (2, 4, 8)
        2. All odds, sorted naturally (1, 11, 15, 17)
        */
    }
}

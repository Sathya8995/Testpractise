package org.example;

import java.util.*;

public class QueueXample {
    public static void main(String[] args) {
        Queue<Object> queue1 = new LinkedList<>();
        Queue<Object> queue2 = new ArrayDeque<>();
        Queue<Object> queue3 = new PriorityQueue<>();

        System.out.println("Linkedlist Queue");
        queue1.offer(6);
        queue1.offer(5);
        queue1.offer(4);
        queue1.offer(3);
        queue1.offer(2);
        queue1.offer(1);
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.poll();
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.poll();
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.poll();
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.offer(4);
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.poll();
        System.out.println(queue1);
        System.out.println(queue1.peek());

        System.out.println("ArrayDeque Queue");
        queue2.offer(6);
        queue2.offer(5);
        queue2.offer(4);
        queue2.offer(3);
        queue2.offer(2);
        queue2.offer(1);
        System.out.println(queue2);
        System.out.println(queue2.peek());
        queue2.poll();
        System.out.println(queue2);
        System.out.println(queue2.peek());
        queue2.poll();
        System.out.println(queue2);
        System.out.println(queue2.peek());
        queue2.poll();
        System.out.println(queue2);
        System.out.println(queue2.peek());
        queue2.offer(4);
        System.out.println(queue2);
        System.out.println(queue2.peek());
        queue2.poll();
        System.out.println(queue2);
        System.out.println(queue2.peek());

        System.out.println("PriorityQueue Queue");
        queue3.offer(6);
        queue3.offer(1);
        queue3.offer(3);
        queue3.offer(2);
        queue3.offer(4);
        queue3.offer(5);
        System.out.println(queue3);
        System.out.println(queue3.peek());
        queue3.poll();
        System.out.println(queue3);
        System.out.println(queue3.peek());
        queue3.poll();
        System.out.println(queue3);
        System.out.println(queue3.peek());
        queue3.poll();
        System.out.println(queue3);
        System.out.println(queue3.peek());
        queue3.offer(4);
        System.out.println(queue3);
        System.out.println(queue3.peek());
        queue3.poll();
        System.out.println(queue3);
        System.out.println(queue3.peek());


    }
}

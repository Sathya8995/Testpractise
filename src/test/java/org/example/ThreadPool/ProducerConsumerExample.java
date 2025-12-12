package org.example.ThreadPool;

import java.util.concurrent.*;

public class ProducerConsumerExample {
    private static final int BUFFER_SIZE = 10;
    private static BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());



        producerThread.start();
        consumerThread.start();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.schedule(() -> {
            producerThread.interrupt();
            consumerThread.interrupt();
            scheduler.shutdown();},10,TimeUnit.SECONDS);

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                int item = 1;
                while (true) {
                    // Produce item
                    buffer.put(item++);

                    System.out.println("Produced item: " + (item - 1));
                    Thread.sleep(1000); // Simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            try {
                while (true) {
                    // Consume item
                    int item = buffer.take();

                    System.out.println("Consumed item: " + item);
                    Thread.sleep(2000); // Simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

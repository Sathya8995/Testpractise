package org.example.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {
    public static void main(String[] args) {
        //Fixed Thread Pool
        //Create a FixedThreadPool with 3 threads
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        System.out.println("\nFixed Thread Pool:");
        // Submit tasks to the FixedThreadPool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                // Task execution
                System.out.println("Fixed Thread Task " + taskId +
                        " executed by Thread: " +
                        Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();
        try {
            // Wait up to 60 seconds for tasks to finish
            if (!fixedThreadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                fixedThreadPool.shutdownNow(); // Force shutdown if timeout
            }
        } catch (InterruptedException e) {
            fixedThreadPool.shutdownNow();
        }
        // Cached Thread Pool
        // Create a CachedThreadPool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        System.out.println("\nCached Thread Pool:");
        // Submit tasks to the CachedThreadPool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                // Task execution
                System.out.println("Cached Thread Task " + taskId +
                        " executed by Thread: " +
                        Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();
        try {
            // Wait up to 60 seconds for tasks to finish
            if (!cachedThreadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                cachedThreadPool.shutdownNow(); // Force shutdown if timeout
            }
        } catch (InterruptedException e) {
            cachedThreadPool.shutdownNow();
        }

        // Single Thread Executor
        // Create a SingleThreadExecutor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        System.out.println("\nSingle Thread Executor:");
        // Submit tasks to the SingleThreadExecutor
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                // Task execution
                System.out.println("Single Thread Task " + taskId +
                        " executed by Thread: " +
                        Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();
        try {
            // Wait up to 60 seconds for tasks to finish
            if (!singleThreadExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                singleThreadExecutor.shutdownNow(); // Force shutdown if timeout
            }
        } catch (InterruptedException e) {
            singleThreadExecutor.shutdownNow();
        }

        // Scheduled Thread Pool
        // Create a ScheduledThreadPool with 2 threads
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        AtomicInteger count1 = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();
        // Schedule a task to execute after 5 seconds
        scheduledThreadPool.schedule(() ->
                        System.out.println("Scheduled Task"),
                5, TimeUnit.SECONDS);

        // Schedule a task to execute every 1 second, starting immediately
        scheduledThreadPool.scheduleWithFixedDelay(() ->
                {System.out.println("Scheduled FixedDelay Task");
                    count2.getAndIncrement();},
                0, 1, TimeUnit.SECONDS);

        // Schedule a task to execute every 1 second, starting immediately
        scheduledThreadPool.scheduleAtFixedRate(() ->
                {System.out.println("Scheduled FixedRate Task");
                    count1.getAndIncrement();},
                0, 1, TimeUnit.SECONDS);

        //shutdown the scheduler
        scheduledThreadPool.schedule(() ->
                {scheduledThreadPool.shutdown();
                    {try {
                            // Wait up to 4 seconds for tasks to finish
                            if (!scheduledThreadPool.awaitTermination(4, TimeUnit.SECONDS)) {
                                scheduledThreadPool.shutdownNow(); // Force shutdown if timeout
                                System.out.println("FixedRate count: "+ count1);
                                System.out.println("FixedDelay count: "+ count2);
                            }
                        } catch (InterruptedException e) {
                            scheduledThreadPool.shutdownNow();
                        }}},
                10, TimeUnit.SECONDS);

    }
}

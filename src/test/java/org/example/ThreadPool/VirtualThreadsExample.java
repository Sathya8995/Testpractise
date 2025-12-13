package org.example.ThreadPool;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsExample {
    private static HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws InterruptedException {
        final int numberOfThreads = 100_000;

        List<Thread> listThreads = new ArrayList<>();
        Runnable objRunnable = () -> {
                // Simulate fetcing data from URL
                //System.out.println("Fetching data from API");
                try {
                    Thread.sleep(10000);// Simulate time taken for fetching data
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //System.out.println("Data fetched from API");
        };

        for (int i =0; i< numberOfThreads; i++){
           Thread thread = Thread.startVirtualThread(objRunnable);
           thread.setName("Thread " + i);
           System.out.println(thread.getName());
           listThreads.add(thread);
        }
        for(Thread t:listThreads){
            t.join();
            System.out.println(t.getName() + " Completed");
        }
    }
}

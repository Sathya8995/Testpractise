package org.example.ThreadPool;

public class  ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();

        //Simulate a user landing on the webpage
        Long userId = 12345L;
        Long userId1 = 56789L;

        // Handle the request in a new thread
        Thread requestThread = new Thread(() -> {
            System.out.println("Started Thread for " + userId);
            userIdThreadLocal.set(userId);
            //process logic
            //Database call and actions
            System.out.println("Completed logic for " + userIdThreadLocal.get());
            //good coding practise to remove threadlocal object
             userIdThreadLocal.remove();
            System.out.println("Removed " + userIdThreadLocal.get());
        });

        Thread requestThread1 = new Thread(() -> {
            System.out.println("Started Thread for " + userId1);
            userIdThreadLocal.set(userId1);
            //process logic
            //Database call and actions
            System.out.println("Completed logic for " + userIdThreadLocal.get());
            //good coding practise to remove threadlocal object
            userIdThreadLocal.remove();
            System.out.println("Removed " + userId1);
        });

        requestThread.start();
        requestThread1.start();
        InheritableThreadLocal<String> obj = new InheritableThreadLocal<>();
        Thread parentThread = new Thread(() -> {
            obj.set("Instagram");
            Thread childThread = new Thread(() -> {
                userIdThreadLocal.set(12345678L);
                System.out.println("User ID: " + userIdThreadLocal.get());
                System.out.println("Platform: " + obj.get());
            });
            childThread.start();

        });
        parentThread.start();

    }
}

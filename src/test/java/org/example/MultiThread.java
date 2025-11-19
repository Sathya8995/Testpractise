package org.example;

import java.util.ArrayList;
import java.util.Collection;

class Counter{
    private int count=0;
    //        synchronized method is called to avoid race condition
    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
public class MultiThread{
    public static void main(String[] args) throws InterruptedException {

        // Runnable interface is implemented, Lamda expression is used to call increment()
//        Threads are used, t1.start() and Thread safety is used, t1.join()
//        synchronized method is called to avoid race condition
        Counter c = new Counter();
        Runnable ob = () ->
        {
                for(int i =0;i<10000;i++){
                    c.increment();
                }
        };
        Runnable ob1 = () ->
        {
            for(int i =0;i<10000;i++){
                c.increment();
            }
        };

        Thread t1 = new Thread(ob);
        Thread t2 = new Thread(ob1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(c.getCount());
    }
}

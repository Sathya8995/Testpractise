package org.example.Garbage;

public class GarbageEx {
    public static void main(String[] args) {
         for(int i =0; i<100000; i++){
             Object obj = new Object();
         }

         //Explicitly trigger garbage collection
        System.gc();

         try{
             Thread.sleep(5000);
         }
         catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

         byte[] largeArray = new byte[150*1024*1024];

        for(int i =0; i<100000; i++){
            Object obj = new Object();
        }

        //Explicitly trigger garbage collection
        System.gc();
    }
}

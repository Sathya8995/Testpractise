package org.example.Heap;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(25,35,45,55,65,75,85,95,10,11,12,13,14,15));
        MinHeap<Integer> heap = new MinHeap<>(list);
        MinHeap<Integer> heap1 = new MinHeap<>(list);

         //printing the heap!
        System.out.println("printing the heap!");
        System.out.println(heap.getList());
        //removing from heap
        System.out.println("removing from heap");
        System.out.println(heap.remove());
        // printing the heap!
        System.out.println("printing the heap!");
        System.out.println(heap.getList());
        //removing from heap
        System.out.println("removing from heap");
        System.out.println(heap.remove());
        //removing from heap
        System.out.println("removing from heap");
        System.out.println(heap.remove());
        // printing the heap!
        System.out.println("printing the heap!");
        System.out.println(heap.getList());
        //inserting in the heap
        System.out.println("Inserting elements 9 - 5 in the heap!");
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        System.out.println("printing the heap!");
        System.out.println(heap.getList());
        //Sorting the heap
        System.out.println("Sorting the heap!");
        heap.heapSort();
        System.out.println(heap.getList());

        System.out.println("Printing the original list: " + list);
        System.out.println("Printing the sorted list: " + heap1.heapSort());

        Queue<Integer> queue = new PriorityQueue<>();
    }
}

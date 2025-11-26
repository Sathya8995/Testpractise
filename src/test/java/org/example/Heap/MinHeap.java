package org.example.Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public MinHeap() {
        this.list = new ArrayList<T>();
    }

    public MinHeap(ArrayList<T> list1) {
        this.list = new ArrayList<T>();
        // Use the optimized buildHeap
        buildHeap(list1);
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int getParent(int index){
        return (index-1)/2;
    }

    private int getLeft(int index){
        return (index*2)+1;
    }
     private int getRight(int index){
        return (index*2)+2;
    }

    // O(N) Time Complexity - Highly Recommended
    private void buildHeap(ArrayList<T> initialList) {
        // 1. Copy all elements directly
        this.list.addAll(initialList);

        // 2. Find the index of the last non-leaf node
        int firstNonLeaf = getParent(list.size() - 1);

        // 3. Iterate backward, calling downHeap on each non-leaf node
        for (int i = firstNonLeaf; i >= 0; i--) {
            downHeap(i);
        }
    }

    public void insert(T value){
        list.add(value);
        int index = list.size() - 1;
        upHeap(index);
    }

    private void upHeap(int index){
        if(index ==0){
            return;
        }
        int parentIndex = getParent(index);

        if(list.get(index).compareTo(list.get(parentIndex))<0){
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from empty Heap!");
        }
                                // For broader and older Java Compatibility
        T value = list.get(0); // Use get(0) instead of getFirst()
        T last = list.remove(list.size() - 1); // Use remove(size-1) instead of removeLast()
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return value;
    }

    private void downHeap(int index){
        int min = index;
        int left = getLeft(index);
        int right = getRight(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if(min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

    public ArrayList<T> getList() {
        return list;
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (! list.isEmpty()){
            data.add(this.remove());
        }
        list = data;
        return data;
    }
}

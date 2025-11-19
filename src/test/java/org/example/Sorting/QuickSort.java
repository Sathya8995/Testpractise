package org.example.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {24,543,26,1,75,83,231,346,1324,6,32,2,6,4,1,7,434,234};
        quicksort(arr,0,arr.length-1);
        System.out.println("sorted array: "+ Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int i = low -1;
        int pivot = arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}

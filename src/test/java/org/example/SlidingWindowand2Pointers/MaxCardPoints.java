package org.example.SlidingWindowand2Pointers;

public class MaxCardPoints {
    public static void main(String[] args) {
        int [] arr = {6,2,3,4,7,2,1,7,1};
        int k =5;
        getMaxPoints(arr,k);
    }

    public static void getMaxPoints(int[] arr, int k){
        int sum =0;
        int sum1=0;
        int length = arr.length - 1;

        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        sum1 = sum;
        for(int i=k-1, j=0; i>=0; i--, j++){
            sum1 = sum1 - arr[i] + arr[length-j];
            if(sum1>sum){
                sum = sum1;
            }
        }
        System.out.println("Maximum points: " + sum);
    }
}

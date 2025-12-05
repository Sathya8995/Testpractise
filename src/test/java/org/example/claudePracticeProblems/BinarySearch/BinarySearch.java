package org.example.claudePracticeProblems.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1};
        System.out.println(shipWithinDays(nums, 4));

    }

    public static int search(int[] nums, int target) {
        int l=0;
        int r = nums.length -1;
        int mid;
        while (l<r){
            mid = (l+r)/2;
            if(target == nums[mid]){
                return mid;
            } else if (target < nums[mid]){
                r = mid -1;
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }

    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in the sorted left half
                    right = mid - 1;
                } else {
                    // Target is in the right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in the sorted right half
                    left = mid + 1;
                } else {
                    // Target is in the left half
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int l1 = 0;
        int r1 = nums.length-1;
        int mid1;
        int l2 =0;
        int r2 = nums.length-1;
        int mid2;
        int res1 =0, res2 =0;
        if (nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        if(nums.length == 1){
            if(nums[0] == target){
                return new int[] {0,0};
            }
            else{
                return new int[] {-1,-1};
            }
        }
        if(nums[0] == nums[nums.length-1]){
            if(nums[0] == target){
                return new int[] {0,nums.length-1};
            }
            else {
                return new int[] {-1,-1};
            }
        }
        if(nums[0] == target){
            if(nums[1] != target){
                return new int[] {0,0};
            }
            else{
                while (l2<=r2){
                    mid2 = (l2+r2)/2;
                    if (nums[mid2] == target){
                        if(nums[mid2] < nums[mid2+1]){
                            res2 = mid2;
                            break;
                        }
                        else{
                            l2 = mid2 +1;
                        }
                    }
                    else if (nums[mid2] < target){
                        l2 = mid2 +1;
                    }
                    else {
                        r2 = mid2 -1;
                    }
                }
                return new int[] {0,res2};
            }
        }
        if(nums[nums.length-1] == target){
            if(nums[nums.length-2] != target){
                return new int[] {nums.length-1,nums.length-1};
            }
            else{
                while (l1<=r1){
                    mid1 = (l1+r1)/2;
                    if (nums[mid1] == target){
                        if(nums[mid1] > nums[mid1-1]){
                            res1 = mid1;
                            break;
                        }
                        else{
                            r1 = mid1 -1;
                        }
                    }
                    else if (nums[mid1] < target){
                        l1 = mid1 +1;
                    }
                    else {
                        r1 = mid1 -1;
                    }
                }
                return new int[] {res1,nums.length-1};
            }
        }
        while (l1<=r1){
            mid1 = (l1+r1)/2;
            if (nums[mid1] == target){
                if(nums[mid1] > nums[mid1-1]){
                    res1 = mid1;
                    break;
                }
                else{
                    r1 = mid1 -1;
                }
            }
            else if (nums[mid1] < target){
                l1 = mid1 +1;
            }
            else {
                r1 = mid1 -1;
            }
        }
        if (res1 ==0){
            return new int[] {-1,-1};
        }
        while (l2<=r2){
            mid2 = (l2+r2)/2;
            if (nums[mid2] == target){
                if(nums[mid2] < nums[mid2+1]){
                    res2 = mid2;
                    break;
                }
                else{
                    l2 = mid2 +1;
                }
            }
            else if (nums[mid2] < target){
                l2 = mid2 +1;
            }
            else {
                r2 = mid2 -1;
            }
        }
        return new int[] {res1,res2};
    }

    public static int shipWithinDays(int[] weights, int days) {
        int capacity =0;
        int mid;
        int maxCapacity = 0;
        int minCapacity;
        for (int weight : weights) {
            maxCapacity += weight;
        }
        minCapacity = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > minCapacity) {
                minCapacity = weights[i];
            }
        }

        int l=minCapacity;
        int r = maxCapacity;
        while (l<=r) {
            mid = (l + r) / 2;
            if (checkShip(weights, days, mid)){
                capacity = mid;
                r = mid -1;
            }
            else{
                l = mid +1;
            }
        }
        return capacity;
    }

    public static boolean checkShip(int[] weights, int days, int capacity){
        int sum = 0;
        int i = 0;
        while (i < weights.length){
            sum += weights[i];
            if(sum > capacity){
                days --;
                sum = weights[i];
            }

            if(i == weights.length - 1){
                if(sum <= capacity){
                    days --;
                    sum = 0;
                }
            }

            if(days < 0){
                return false;
            }
            i++;
        }
        return true;
    }

}

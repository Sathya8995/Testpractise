package org.example.SlidingWindowand2Pointers;

public class BinarySubarrayswithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal =2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count =0;
        int sum = 0;
        int l =0;
        int r=0;
        while (r<nums.length){
            sum += nums[r];
            if(sum == goal){
                count++;
            }
            while (sum >goal){
                sum -= nums[l];
                if(sum == goal + nums[r]){
                    count++;
                }

            }
            r++;
        }
        return count;
    }
}

package org.example.SlidingWindowand2Pointers;

public class MinimumSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        int sum =0;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            sum += nums[r];
            while(sum >= target){
                minCount = Math.min(minCount,(r-l+1));
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}

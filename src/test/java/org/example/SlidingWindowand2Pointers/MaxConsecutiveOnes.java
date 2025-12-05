package org.example.SlidingWindowand2Pointers;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,0,0};
        System.out.println(longestOnes(nums,0));
    }

    public static int longestOnes(int[] nums, int k) {
        int count =0;
        int l=0;
        int r=0;
        if(k>0){
            while(r<nums.length){
                if(nums[r]==0){
                    if(k>0){
                        k--;
                    }
                    else{
                        while(l<r){
                            if(nums[l]==0){
                                k++;
                                l++;
                                break;
                            }
                            l++;
                        }
                        if(k >0)
                            k--;
                    }
                }
                count = Math.max(count,(r-l+1));
                r++;
            }
        }
        else{
            while(r<nums.length){
                if(nums[r]==0){
                    l=r+1;
                }
                count = Math.max(count,(r-l+1));
                r++;
            }
        }
        return count;
    }
}

package org.example.SlidingWindowand2Pointers;

import java.util.HashMap;
import java.util.Map;

public class subarraysWithKDistinct {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k =3;
        System.out.println(subarraysWithKDistinct(nums,k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count =0;
        int l =0;
        int r = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r < nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while (map.size() > k){
                map.put(nums[l],map.get(nums[l]) -1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
                count += r-l-1;

            }

            if(map.size() ==k){
                count++;
            }

            r++;
        }
        return count;
    }
}

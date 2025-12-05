package org.example.SlidingWindowand2Pointers;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitsinBasket {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,2,3,4,3,4,3,4,3,4,3,4};

        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] fruits){
        int maxcount =0;
        int l =0;
        int r=0;
        Map<Integer,Integer> map = new TreeMap<>();
        while (r<fruits.length){
            map.put(fruits[r],r);
            if(map.size() >2 ){
                Map.Entry<Integer, Integer> minEntry = map.entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue())
                        .orElse(null);

                if (minEntry != null) {
                    l = 1 + minEntry.getValue();
                    map.remove(minEntry.getKey());
                }

            }
            maxcount = Math.max(maxcount,(r- l +1));
            r++;
        }
        return maxcount;
    }
}

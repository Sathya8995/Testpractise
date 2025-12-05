package org.example.SlidingWindowand2Pointers;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubstrings {
    public static void main(String[] args) {
        String s = "aaacb";
        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int count =0;
        int l=0;
        int r=0;
        Map<Character,Integer> freqMap = new HashMap<>();
        while (r<s.length()){
            freqMap.put(s.charAt(r),freqMap.getOrDefault(s.charAt(r),0)+1);
            while(freqMap.size() == 3){
                count += s.length() - r;

                freqMap.put(s.charAt(l),freqMap.get(s.charAt(l))-1);

                if(freqMap.get(s.charAt(l))==0){
                    freqMap.remove(s.charAt(l));
                }

                l++;
            }
            r++;
        }
        return count;
    }
}

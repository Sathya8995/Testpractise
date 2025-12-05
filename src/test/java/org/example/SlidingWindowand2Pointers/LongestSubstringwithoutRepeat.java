package org.example.SlidingWindowand2Pointers;

import java.util.HashMap;

public class LongestSubstringwithoutRepeat {
    public static void main(String[] args) {
        String str = "thisisalongx";
        int maxLength = 0;
        int l=0;
        int r=0;
        HashMap<Character, Integer> isSeen = new HashMap<Character, Integer>();
        char[] substr = str.toCharArray();
        while(r<substr.length ){
            if(!isSeen.containsKey(substr[r])){
                isSeen.put(substr[r],r);
            }
            else{
                if(l<=isSeen.get(substr[r])){
                l = isSeen.get(substr[r]) + 1;}
                isSeen.put(substr[r],r);
            }
            maxLength = Math.max(maxLength,(r-l+1));
            r++;
        }
        System.out.println("Length of the longest substring is " + maxLength);
    }
}

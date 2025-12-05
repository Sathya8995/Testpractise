package org.example.SlidingWindowand2Pointers;

import java.util.*;

public class SubstringatmostKdistinct {
    public static void main(String[] args) {
        String str = "thisisalongx";
        int k = 4;
        int result = getCount(str, k);
        System.out.printf("Length of substring with at most %d distinct characters: %d%n", k, result);
    }

    public static int getCount(String s, int k) {
        int maxCount = 0;
        int l = 0;
        Map<Character, Integer> charFreq = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);

            // Shrink window until we have at most k distinct characters
            while (charFreq.size() > k) {
                char leftChar = s.charAt(l);
                charFreq.put(leftChar, charFreq.get(leftChar) - 1);

                // Remove character if count becomes 0
                if (charFreq.get(leftChar) == 0) {
                    charFreq.remove(leftChar);
                }
                l++;
            }

            maxCount = Math.max(maxCount, r - l + 1);
        }

        return maxCount;
    }
}
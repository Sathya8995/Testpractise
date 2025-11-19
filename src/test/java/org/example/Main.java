package org.example;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("=== Testing practise class methods ===\n");
        
        // Create an instance of practise class
        practise p = new practise();
        
        // Test array operations
        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(testArray));
        
        // Test reverse array
        practise.reverseArray(testArray);
        System.out.println("After reversing: " + java.util.Arrays.toString(testArray));
        
        // Test rotate array
        practise.rotateArray(testArray, 2);
        System.out.println("After rotating by 2: " + java.util.Arrays.toString(testArray));
        
        // Test string operations
        String testString = "hello";
        System.out.println("\nOriginal string: " + testString);
        
        char[] reversed = practise.reverseString(testString);
        System.out.println("Reversed string: " + new String(reversed));
        
        // Test anagram
        System.out.println("\nTesting anagram:");
        practise.findAnagram("listen", "silent");
        practise.findAnagram("hello", "world");
        
        // Test palindrome
        System.out.println("\nTesting palindrome:");
        practise p2 = new practise();
        System.out.println("Is 121 a palindrome? " + p2.isPalindrome(121));
        System.out.println("Is 123 a palindrome? " + p2.isPalindrome(123));
        
        // Test two sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = p2.twoSum(nums, target);
        System.out.println("\nTwo sum for target " + target + ": " + java.util.Arrays.toString(result));
        
        // Test missing number
        int[] missingArray = {1, 2, 4, 5, 6};
        System.out.println("\nMissing number in array " + java.util.Arrays.toString(missingArray) + 
                          " is: " + practise.fingmissingNum(missingArray));
        
        // Test string compression
        System.out.println("\nString compression:");
        practise.compressString("aabcccccaaa");
        
        System.out.println("\n=== All tests completed ===");
    }
}
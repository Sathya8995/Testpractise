package org.example;

import java.lang.classfile.components.ClassPrinter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class practise {

    public static void rotateArray(int[] arr, int k){
        k = k%arr.length;
        int n = arr.length-1;
        reverseArray(arr,0,n);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n);
    }
    public static void reverseArray(int[] arr){
        int mid = arr.length/2;
        int n = arr.length-1;
        for(int i=0; i< mid; i++){
            int temp = arr[i];
            arr[i] = arr[n-i];
            arr[n-i] = temp;
        }

    }

    public static void reverseArray(int[] arr, int left, int right){
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right]= temp;
            left++;
            right--;
        }

    }

    public static char[] reverseString(String str){
        char[] arr = str.toCharArray();
        int left =0;
        int right = str.length() -1;
        while(left<right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static void moveZeros(int[] arr, int n){
        if(n==1){
            return ; }
        for(int i=0;i<n-1;i++){
            if(arr[i]==0){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        moveZeros(arr,n-1);
    }

    public static int fingmissingNum(int[] arr){
        int n = arr.length;
        int exp_sum = ((n+1)*(n+2))/2;
        int ac_sum=0;
        for(int i=0;i<n;i++){
            ac_sum+=arr[i];
        }
        return exp_sum-ac_sum;
    }

    public static void findSubarray(int[] arr, int sum) {
        int start = 0, currSum = 0;
        ArrayList<Integer> sub = new ArrayList<>(10);
        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];
            while (currSum > sum) {
                currSum -= arr[start++];
            }
            if (currSum == sum) {
                System.out.println("Subarray found from index " + start + " to " + end);
                for(int i = start; i<=end; i++){
                    sub.add(arr[i]);
                }
                System.out.println(sub);
                return;
            }
        }
        System.out.println("No subarray found");
    }

    public static void printDuplicates(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>(arr.length);
        Arrays.sort(arr); // Sort array first
        boolean found = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                //System.out.print(arr[i] + " ");
                al.add(arr[i]);
                found = true;
                i++;
            }
        }

        if (!found) {
            System.out.println("No duplicates found.");
        }
        else {
            System.out.println(al);
        }
    }

    public static void findAnagram(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String s3 = new String(s1);
        String s4 = new String(s2);
        //System.out.println(s3+" and "+s4);
        if(s3.equalsIgnoreCase(s4)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }

    public static void removeduplicatfromString(String str){
        boolean[] seen = new boolean[256];
        StringBuilder result = new StringBuilder();

        for(int i =0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(!seen[ch]){
                seen[ch]=true;
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }

    public static void countwordsinString(String str){
        int count = 1;
        for(int i = 2; i<str.length()-1; i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        System.out.println("Number of words are: "+ count);
    }

    public static String commonstringPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Start with the first string as the prefix

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void firstUniqueChar(String str){
        int[] freq = new int[256];
        boolean found = false;
        for (int i =0; i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch]++;
        }

        for (int i =0; i<str.length();i++) {
            char ch = str.charAt(i);
            if (freq[ch]==1){
                found=true;
                System.out.println(ch);
                break;
            }
        }
        if(!found){
            System.out.println("No unique characters");
        }
    }

    public static void compressString(String str){
    StringBuilder result = new StringBuilder();
    int count =1;
    String str2 = str+" ";
        System.out.println(str2);
   for(int i=0; i<str2.length()-1;i++){
       if(str2.charAt(i)==str2.charAt(i+1)){
           count++;
       }
       if(str2.charAt(i) != str2.charAt(i+1)){
           result.append(str2.charAt(i));
           result.append(count);
           count=1;
       }
        }
        System.out.print(result.toString());

    }

    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int [] arr = new int[10];
        for(int i =0; i<nums.length-1;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        for(int i =0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long y = x;
        long z = x;
        long k=0;
        int digit=0;
        while(z/10>0){
            digit++;
            z/=10;
        }
        while(digit+1>0){
            k+=Math.pow(10,digit)*(y%10);
            y/=10;
            digit--;
        }

        if(k==x){
            return true;
        }
        else{
            return false;
        }
    }

    public static int removeDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(10);
        for(int i =0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length-1]);
        for(int i =0; i< list.size();i++){
            arr[i] = list.get(i);
        }
        return list.size();
    }
    public static int strStr(String haystack, String needle) {
        int index=0;
        int j=1;
        boolean found = false;
        if(needle.length()==1&&haystack.length()==1){
            if(needle.charAt(0)==haystack.charAt(0)){
                return 0;
            }
            else{
                return -1;
            }
        }
        if(needle.length() == 1){
            for(int e=0;e<haystack.length();e++){
                if(needle.charAt(0)==haystack.charAt(e)){
                    return e;
                }
            }
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        for (int i =0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                index = i;
                int k = i+1;
                while(j<needle.length() && k< haystack.length()){
                    if(haystack.charAt(k)==needle.charAt(j)){
                        found=true;
                        j++;
                        k++;
                    }
                    else{
                        found=false;
                        j=1;
                        break;
                    }

                }
                if(j<needle.length()){
                    found=false;
                }

            }
            if(found){
                break;
            }
        }
        if(found){
            return index;
        }
        else{
            return -1;
        }
    }

    public static boolean areOccurrencesEqual(String s) {
        ArrayList<Integer> list = new ArrayList<>(10);
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i =0; i<freq.length-1;i++){
            if(freq[i]==0){
                continue;
            }
            else{
                list.add(freq[i]);
            }
        }
        for(int i=0;i<list.size()-1;i++){
            if(!Objects.equals(list.get(i), list.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    public static long getLucky(String s, int k) {
        int j =1;
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(char ch ='a';ch<='z';ch++){
            map.put(ch, j++);
        }
        for(int i=0;i<s.length();i++){
            result.append(map.get(s.charAt(i)));
        }
        String str2 = new String(result);
        long number = Long.parseLong(str2);

        int rem=0;
        for(int i =1;i<=k;i++){
            while(number>0){
                rem+=number%10;
                number/=10;
            }
            number=rem;
        }
        return number;

    }

    public static boolean anagram2(String s1, String s2){
        boolean flag=true;
        int[] freq = new int[52];
        for(int i =0;i<s1.length();i++){
            char ch =s1.charAt(i);
            freq[ch-'a']++;
        }
        for(int i =0;i<s2.length();i++){
            char ch =s2.charAt(i);
            freq[ch-'a']--;
        }
        for(int i =0;i<freq.length;i++){
            if (freq[i] != 0) {
                flag = false;
//                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
//        String haystack = "mississippi";
//        String needle = "issip";
        //int [] arr = {1,2,2,3,3,3,4,5,5};
        //String[] inp = {"flow","flower","flight"};
//        int sum=Arrays.stream(arr).sum();
//        System.out.println(sum);
          String str1 = "silent";
          String str2 = "kisten";
//        boolean bool = true;
        //System.out.println("Input array :"+Arrays.toString(arr));
//        System.out.println("Input String :");
//        System.out.println(str);

        //1. reverse array

//        reverseArray(arr,0,arr.length-1);
//        System.out.println("reversed array :");
//        System.out.println(Arrays.toString(arr));

        //2. rotate array

//        int k =4; //rotate by k
//        rotateArray(arr,k);
//        System.out.println("rotated array :");
//        System.out.println(Arrays.toString(arr));

        //3. Reverse String
//        String reversed_str = new String(reverseString(str));
//        System.out.println("Reversed array:");
//        System.out.print(reversed_str);

        //4. Check palindrome
//        String reversed_str = new String(reverseString(str));
//        if(reversed_str.equalsIgnoreCase(str))
//            System.out.println(bool);
//        else System.out.println(!bool);

        //5. move zeros to end of array
//        moveZeros(arr,arr.length);
//        System.out.println("The resulted array: " + Arrays.toString(arr));

        //6. Missing number in the array
        //System.out.println("Missing number is: "+ fingmissingNum(arr));

        //7. find sub array
        //findSubarray(arr, 33);

        //8. Finding duplicates in array
        //printDuplicates(arr);

        //9. Anagram
//        String s1 = "Silent";
//        String s2 = "Listen";
//        findAnagram(s1.toLowerCase(),s2.toLowerCase());

        //10. Duplicate char in string
//        removeduplicatfromString(str);

        //11. count number of words in a string
        //countwordsinString(str);

        //12. largest common prefix
        //commonstringPrefix(inp);

        //13. first unique character in a String
        //firstUniqueChar(str.toLowerCase());

        //14. compress string
        //compressString(str);

        //15. remove duplicate
        //removeDuplicates(arr);

        //16. needle in haystack
//        int result=strStr(haystack,needle);
//        System.out.println(result);

        //17.
        //System.out.println(areOccurrencesEqual(str));

        //18.
//        long ans = getLucky(str,2);
//        System.out.println(ans);

        boolean flag= anagram2(str1,str2);
        System.out.println(flag);
    }
}

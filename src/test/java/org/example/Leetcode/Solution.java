package org.example.Leetcode;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int count =0;
        if(word1.length()>word2.length()){
            for(int i=0; i<word2.length();i++){
                str.append(word1.charAt(i));
                str.append(word2.charAt(i));
                count = i+1;
            }
            for(int j = count;j<word1.length();j++){
                str.append(word1.charAt(j));
            }
        }
        else{
            for(int i=0; i<word1.length();i++){
                str.append(word1.charAt(i));
                str.append(word2.charAt(i));
                count = i+1;
            }
            for(int j = count;j<word2.length();j++){
                str.append(word2.charAt(j));
            }
        }
        return str.toString();
    }
}

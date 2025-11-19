package org.example.claudePracticeProblems.WordCounter;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String sentence = "java is great and java is fun and java is powerful";

        String[] words = sentence.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String a: words){
            if (map.containsKey(a))
                map.put(a,map.get(a)+1);
            else
                map.put(a,1);
        }
        System.out.println(map);
    }
}

package org.example.claudePracticeProblems.RemoveDuplicates;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println("Original list: "+ numbers);
        Set<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        tset.addAll(numbers);
        numbers = new ArrayList<>(tset);
        System.out.println("Removed duplicate and reversed list: "+numbers);

        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> result = numbers1.stream()
                .distinct()                           // Remove duplicates
                .sorted(Collections.reverseOrder())   // Sort descending
                .toList();
        System.out.println(result);
    }
}

package org.example.claudePracticeProblems.StudentGradeMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentGrade {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(Map.ofEntries(
                Map.entry("AB", 90),
                Map.entry("CD", 50),
                Map.entry("EF", 79),
                Map.entry("GH", 81),
                Map.entry("IJ", 87)
        ));
//        Map.Entry<String, Integer> entry = map
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .orElse(null);
//        try {
//            assert entry != null;
//            System.out.println("Student with highest grade "+entry.getKey());
//        } catch (Exception e) {
//            System.out.println("An error occurred while printing the key: " + e.getMessage());
//        }
        System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null));
        map
                .entrySet()
                .stream()
                .filter(ent -> ent.getValue()>80)
                .forEach(ent -> System.out.println(ent.getKey()+":"+ent.getValue()));


        //extra not related to above
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers = numbers.stream().filter(n -> n%2==0).map(n -> n*2).toList();
        System.out.println(numbers);
    }
}

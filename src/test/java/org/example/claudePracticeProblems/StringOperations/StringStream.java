package org.example.claudePracticeProblems.StringOperations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "aqjgbeqj", "Appricot", "cherry", "date");
        Predicate<String> pred = s -> (s.startsWith("A") || s.startsWith("a"));

        Function<String, String> func = String::toUpperCase;
        words = words.stream().filter(pred).map(func).toList();
        System.out.println(words);
    }
}

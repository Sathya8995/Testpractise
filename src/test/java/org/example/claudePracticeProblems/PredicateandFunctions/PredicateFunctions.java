package org.example.claudePracticeProblems.PredicateandFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunctions {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Predicate<Integer> pred1 = n -> n%2==0;
        Predicate<Integer> pred2 = n -> (n>3);

        System.out.println(numbers.stream().filter(pred1.and(pred2)).toList());

        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> addExclamation = s -> s + "!";

        String[] str = {"hello"};

        System.out.println(Arrays.stream(str).map(toUpper.andThen(addExclamation)).toList());

    }
}

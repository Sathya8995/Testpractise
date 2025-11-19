package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsApiDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4,5,6,9,7,2,3,8,1);
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        int result = list.stream()
                .filter(n -> n%2 ==0)
                .map(n -> n*2)
                .reduce(0, Integer::sum);
        System.out.println(result);
        Stream<Integer> s1 = list.stream().sorted();
        System.out.println(s1.toList());
    }
}

package org.example.claudePracticeProblems.SumAverage;

import java.util.Arrays;
import java.util.List;

public class SumAvg {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int sum = numbers.stream().reduce(0, Integer::sum);
        int max = numbers.stream().reduce(0, Integer::max);
        int size = numbers.size();
        int avg = sum/size;
        System.out.println("sum: "+sum+" max: "+max+" avg: "+avg);
    }
}

package org.example.claudePracticeProblems.StudentManagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student sathya = new Student(1, 3.5F,"CS");
        Student akash = new Student(2, 3.7F,"Mech");
        Student barath = new Student(2,4,"ECE");

        List<Student> list = new ArrayList<>();
        Collections.addAll(list, sathya, akash, barath);

        Map<Integer, Student> map = new HashMap<>();
        float res = list.stream().map(Student::getGpa).count();

        System.out.println(map);
    }
}

package org.example.LinkStackQueuePracticeProblems;

import java.util.*;
import java.util.stream.Collectors;

public class BasicLinkedListOperations {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        Collections.addAll(list,1,2,2,3,4,5,6,6,7,8,8,9);
        Collections.addAll(list1,21,22,23,24,25);
        list.addFirst(10);
        list.addLast(11);
        list.add(5,12);
        list.removeFirst();
        list.removeLast();

        reverseList(list);
        System.out.println("Reversed List: "+ list);

        System.out.println("Middle Element is :"+ middleElement(list));

        list=removeDuplicate(list);
        System.out.println("List after removing Duplicate: "+list);

        list.addAll(list1);
        System.out.println(list);
    }

    public static void reverseList(LinkedList<Integer> list){
        Collections.reverse(list);
    }

    public static Integer middleElement(LinkedList<Integer> list){
        if(list.isEmpty()) return null;
        return list.get((list.size())/2);
    }

    public static LinkedList<Integer> removeDuplicate(LinkedList<Integer> list){
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        return new LinkedList<>(set);
    }
}

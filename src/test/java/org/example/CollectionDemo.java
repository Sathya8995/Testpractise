package org.example;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.remove(5);
        int size = nums.size();
        boolean flag = nums.contains(4);

        for(int n: nums){
            System.out.println(n);
        }
        System.out.println("size:"+ size);
        System.out.println("Flag:"+ flag);

        List<Integer> nums1 = new ArrayList<Integer>();
        nums1.add(5);
        nums1.add(6);
        nums1.add(7);
        nums1.add(8);
        System.out.println("Working with Lists, index of a element:"+nums1.indexOf(8));;

        //For unique values but not sorted
        Set<Integer> nums2 = new HashSet<Integer>();
        nums2.add(59);
        nums2.add(36);
        nums2.add(17);
        nums2.add(59);
        nums2.add(68);
        nums2.add(36);
        System.out.println("Working with HashSet");
        for(int n: nums2){
            System.out.println(n);
        }

        //For unique and sorted values
        Set<Integer> nums3 = new TreeSet<Integer>();
        nums3.add(59);
        nums3.add(36);
        nums3.add(17);
        nums3.add(59);
        nums3.add(68);
        nums3.add(36);
        System.out.println("Working with TreeSet");
        for(int n: nums3){
            System.out.println(n);
        }

        //Sorting
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "Sathya","Jaanu","Padmini");
        System.out.println("Original:"+list);
        Comparator<String> comparator = Comparator.comparingInt(String::length);

        list.sort(comparator);
        System.out.println("Sorted based on size:"+list);
        list.set(0,"Sathya");
        list.set(1,"Jaanu");
        list.set(2,"Padmini");
        System.out.println("Back to Original:"+list);

        list.sort(String::compareToIgnoreCase);
        System.out.println("Sorted based on alphabet order:"+list);


    }
}

package org.example.StackProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "{{[[(())]]}}";
        String test4 = "{[}]";
        String test5 = "";

//        System.out.println(test1 + " is balanced: " + isBalanced(test1));
//        System.out.println(test2 + " is balanced: " + isBalanced(test2));
//        System.out.println(test3 + " is balanced: " + isBalanced(test3));
//        System.out.println(test4 + " is balanced: " + isBalanced(test4));
//        System.out.println(test5 + " is balanced: " + isBalanced(test5));
//
//        String s = "AbcdefG";
//        System.out.println("Input String: " + s);
//        System.out.println("Reversed String is " + reverseString(s));

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,4,2,2,5,1,8);
        System.out.println("Input : " + list);
        nextGreaterNUmber(list);
        System.out.println("Output : " + list);
    }

    private static void nextGreaterNUmber(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        for(int num: list){
            stack.push(num);
        }
        list.removeAll(list);
        for(int i=0; i< stack.size()-1; i++){
            for(int j=i+1; j<stack.size(); j++){
                if(stack.get(j)>stack.get(i)){
                    list.add(stack.get(j));
                    flag = true;
                    break;
                }
                else flag =false;
            }
            if(!flag)
                list.add(-1);
        }
        list.add(-1);
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check if brackets match
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets are balanced
        return stack.isEmpty();
    }

    public static String reverseString(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            stack.push(ch);
        }
        StringBuilder str = new StringBuilder(s.length());
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.toString();
    }
}

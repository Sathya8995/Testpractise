package org.example;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Stack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        Collections.addAll(stack,5,6,7,8);
        System.out.println(stack);
        System.out.println(stack.peek());
        java.util.Stack<Integer> stack1 = new java.util.Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.pop();
        stack1.pop();
        System.out.println(stack1);
        System.out.println(stack1.peek());
        Collections.addAll(stack1,5,6,7,8);
        System.out.println(stack1);
        System.out.println(stack1.peek());
//        stack.push(9);
//        Collections.addAll(stack,5,6,7,8);
//        System.out.println(stack);
//        int a = stack.peek();
//        System.out.println(a);
    }
}

package org.example.Trees;

import java.util.Scanner;

public class BinarySearchTree {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    //insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Enter true or false, Do you want to add elements to the tree? ");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input! Please type true or false.");
            scanner.next(); // Skip the invalid token
        }
        boolean flag = scanner.nextBoolean();
        while(flag){
            System.out.println("Enter the value to be added to the binary search tree ");
            int value = scanner.nextInt();
//            if (value == node.value) {
//                System.out.println("Duplicate values not allowed!");
//                return;
//            }
            if (value<root.value){
                if(node.left == null)
                    node.left = new Node(value);
                else
                    goLeft(scanner, node.left, value);
            } else{
                if(node.right == null)
                    node.right = new Node(value);
                else
                    goRight(scanner, node.right, value);
            }
            System.out.println("Enter true or false, Do you want to add more elements: ");
            while (!scanner.hasNextBoolean()) {
                System.out.println("Invalid input! Please type true or false.");
                scanner.next(); // Skip the invalid token
            }
            flag = scanner.nextBoolean();
        }
    }

    public void goLeft(Scanner scanner, Node node, int value){
        if(value< node.value){
            if(node.left == null){
                node.left = new Node(value);
            }
            else
                goLeft(scanner, node.left, value);
        }
        else {
            if(node.right == null)
                node.right = new Node(value);
            else
                goRight(scanner, node.right, value);
        }
    }

    public void goRight(Scanner scanner, Node node, int value){
        if(value< node.value){
            if(node.left == null){
                node.left = new Node(value);
            }
            else
                goLeft(scanner, node.left, value);
        }
        else {
            if(node.right == null)
                node.right = new Node(value);
            else
                goRight(scanner, node.right, value);
        }
    }

    public void display() {
        display(root,0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right,level + 1);

        if (level !=0){
            for (int i = 0; i < level -1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else{
            System.out.println(node.value);
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        tree.populate(scanner);
        tree.display();
    }
}

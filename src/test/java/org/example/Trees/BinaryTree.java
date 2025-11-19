package org.example.Trees;

import java.util.Scanner;

public class BinaryTree {
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

    private void populate(Scanner scanner, Node node){
        System.out.println("Enter true or false, Do you want to enter the left of " + node.value);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input! Please type true or false.");
            scanner.next(); // Skip the invalid token
        }
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);}

        System.out.println("Enter true or false, Do you want to enter the right of " + node.value);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input! Please type true or false.");
            scanner.next(); // Skip the invalid token
        }
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);}
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
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}

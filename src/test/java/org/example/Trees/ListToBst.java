package org.example.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListToBst {
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

    /**
     * Inserts a single value into the BST
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Recursive helper method for insertion
     */
    private Node insertRec(Node node, int value) {
        // Base case: found the correct position
        if (node == null) {
            return new Node(value);
        }

        // Recursively traverse the tree
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        // If value == node.value, we ignore duplicates (BST property)

        return node;
    }

    /**
     * Populates the BST from a list of integers
     */
    public void populate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        for (int value : list) {
            insert(value);
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

    /**
     * Performs in-order traversal (sorted order for BST)
     */
    public void inOrderTraversal() {
        System.out.print("In-order: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    /**
     * Performs pre-order traversal (Root → Left → Right)
     * Useful for: creating a copy of the tree, prefix expressions
     */
    public void preOrderTraversal() {
        System.out.print("Pre-order: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    /**
     * Performs post-order traversal (Left → Right → Root)
     * Useful for: deleting the tree, postfix expressions, calculating tree size
     */
    public void postOrderTraversal() {
        System.out.print("post-order: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    /**
     * Searches for a value in the BST
     */
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        }

        return value < node.value
                ? searchRec(node.left, value)
                : searchRec(node.right, value);
    }

    /**
     * Returns the  height of the tree
     */
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }

        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    /**
     * Checks if the tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int n=0;
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter the number of tree elements ");
        n = scanner.nextInt();
        System.out.println("Enter the root of the tree: ");
        list.addFirst(scanner.nextInt());
        System.out.println("Enter the remaining elements of the Binary Search tree");
        for (int i=1; i<n; i++){
            list.add(scanner.nextInt());
        }

        ListToBst tree = new ListToBst();
        // Populate the tree
        tree.populate(list);
        // Display the tree
        System.out.println("\nTree Structure:");
        tree.display();
        // Show in-order traversal (should be sorted)
        System.out.println();
        tree.inOrderTraversal();

        // Show pre-order traversal
        System.out.println();
        tree.preOrderTraversal();

        // Show post-order traversal
        System.out.println();
        tree.postOrderTraversal();

        // Show tree height
        System.out.println();
        System.out.println("Tree Height: " + tree.height());

        // Optional: Search demo
        System.out.print("\nEnter a value to search (or -1 to skip): ");
        int searchValue = scanner.nextInt();
        if (searchValue != -1) {
            boolean found = tree.search(searchValue);
            System.out.println(searchValue + (found ? " found" : " not found") + " in tree");
        }

    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }

    }
}

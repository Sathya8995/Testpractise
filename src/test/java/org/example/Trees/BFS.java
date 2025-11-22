package org.example.Trees;

import java.util.*;

public class BFS {
    private static class Node{
        Integer value;
        Node left;
        Node right;
        public Node(Integer value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public void populate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        // Create root node
        root = new Node(list.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < list.size()) {
            Node node = queue.poll();

            // Process left child
            if (i < list.size()) {
                Integer leftValue = list.get(i);
                node.left = new Node(leftValue);  // Create node even if value is null
                if (leftValue != null) {
                    queue.offer(node.left);  // Only add to queue if not null
                }
                i++;
            }

            // Process right child
            if (i < list.size()) {
                Integer rightValue = list.get(i);
                node.right = new Node(rightValue);  // Create node even if value is null
                if (rightValue != null) {
                    queue.offer(node.right);  // Only add to queue if not null
                }
                i++;
            }
        }
    }

    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (node.value != null) {
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("|\t\t");
                }
                System.out.println("|------->" + node.value);
            } else {
                System.out.println(node.value);
            }
        }
        display(node.left, level + 1);
    }

    public void bfTraversal(){
        System.out.print("BFS: ");
        //create queue
        Queue<Node> queue2 = new ArrayDeque<>();
        bfDisplay(root, queue2);
        //System.out.println();
    }

    public void bfDisplay(Node node, Queue<Node> queue){
        if(node != null){
            System.out.print(node.value + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            bfDisplay(queue.poll(), queue);
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        BFS tree = new BFS();
        // Populate the tree
        tree.populate(list);
        //tree.display();
        tree.bfTraversal();

    }
}

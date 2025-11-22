package org.example.Leetcode;


import org.example.Trees.ListToBt;

import java.util.*;

public class Solution {
    private static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer value){
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode root;

    public void populate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        // Create root node
        root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < list.size()) {
            TreeNode node = queue.poll();

            // Process left child
            if (i < list.size()) {
                Integer leftValue = list.get(i);
                node.left = new TreeNode(leftValue);  // Create node even if value is null
                if (leftValue != null) {
                    queue.offer(node.left);  // Only add to queue if not null
                }
                i++;
            }

            // Process right child
            if (i < list.size()) {
                Integer rightValue = list.get(i);
                node.right = new TreeNode(rightValue);  // Create node even if value is null
                if (rightValue != null) {
                    queue.offer(node.right);  // Only add to queue if not null
                }
                i++;
            }
        }
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int count =0;
        if(word1.length()>word2.length()){
            for(int i=0; i<word2.length();i++){
                str.append(word1.charAt(i));
                str.append(word2.charAt(i));
                count = i+1;
            }
            for(int j = count;j<word1.length();j++){
                str.append(word1.charAt(j));
            }
        }
        else{
            for(int i=0; i<word1.length();i++){
                str.append(word1.charAt(i));
                str.append(word2.charAt(i));
                count = i+1;
            }
            for(int j = count;j<word2.length();j++){
                str.append(word2.charAt(j));
            }
        }
        return str.toString();
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            for(int i =0; i<levelSize; i++){
                TreeNode current = queue.poll();
                if (current.val != null) {
                    currentLevel.add(current.val);
                }

                if (current.left != null){
                    queue.offer(current.left);
                    }
                if (current.right != null){
                    queue.offer(current.right);
                    }

            }
            list.add(currentLevel);
        }
        return list;
    }

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Add to front or back based on direction
                if (leftToRight) {
                    if(current.val != null)
                        currentLevel.addLast(current.val);
                } else {
                    if(current.val != null)
                        currentLevel.addFirst(current.val);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight;
        }

        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()){
            int levelSize = queue.size();
            double sum =0d;
            for(int i =0; i<levelSize; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            result.add(sum/levelSize);
        }

        return result;
    }

    public void display() {
        display(root, 0);
    }

    private void display(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (node.val != null) {
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("|\t\t");
                }
                System.out.println("|------->" + node.val);
            } else {
                System.out.println(node.val);
            }
        }
        display(node.left, level + 1);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q== null){
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(p);

        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(q);

        while (! queue1.isEmpty()){
            int levelSize1 = queue1.size();
            int levelSize2 = queue2.size();
            if(levelSize1 != levelSize2)
                {
                    return false;
                }
            for(int i =0; i<levelSize1; i++){
                TreeNode current1 = queue1.poll();
                TreeNode current2 = queue2.poll();
                if(!Objects.equals(current1.val, current2.val)){
                    return false;
                }
                if (current1.left != null){
                    queue1.offer(current1.left);
                }
                if (current1.right != null){
                    queue1.offer(current1.right);
                }
                if (current2.left != null){
                    queue2.offer(current2.left);
                }
                if (current2.right != null){
                    queue2.offer(current2.right);
                }
            }

        }
        return true;
    }

    public Integer findRightNext(TreeNode root, int data){
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current.left.val != null){
                queue.offer(current.left);
            }
            if (current.right.val != null){
                queue.offer(current.right);
            }
            if(current.val == data){
                return queue.isEmpty() ? -1 :queue.poll().val;
            }
        }

        return -1;  // No successor found
    }

    public Integer findRightNext1(TreeNode root, int data){
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean found = false;

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            // Skip null nodes or nodes with null values
            if (current == null || current.val == null) {
                continue;
            }

            // If we found the target in previous iteration, return current
            if (found) {
                return current.val;
            }

            // Check if this is the target node
            if(current.val == data){
                found = true;
            }

            // Add children
            if (current.left != null){
                queue.offer(current.left);
            }
            if (current.right != null){
                queue.offer(current.right);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,9,20,null,null,15,7,30,50,25,40));
        Solution tree = new Solution();
        // Populate the tree
        tree.populate(list);
        tree.display();
        System.out.println("\n" + tree.levelOrder(tree.root));


    }
}

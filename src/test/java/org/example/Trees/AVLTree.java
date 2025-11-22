package org.example.Trees;

import java.util.Scanner;

/**
 * Complete AVL Tree Implementation
 * Self-balancing Binary Search Tree
 */
public class AVLTree {

    private static class Node {
        int value;
        int height;  // Height of this node
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 0;  // New nodes have height 0
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // ==================== UTILITY METHODS ====================

    /**
     * Returns the height of a node
     * Height of null node is -1
     */
    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * Updates the height of a node based on its children
     */
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    /**
     * Calculates balance factor
     * BF = height(left) - height(right)
     * BF > 0: left heavy, BF < 0: right heavy, BF = 0: balanced
     */
    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // ==================== ROTATION METHODS ====================

    /**
     * RIGHT ROTATION (for LL case)
     *
     *       y                x
     *      / \              / \
     *     x   C    →       A   y
     *    / \                  / \
     *   A   B                B   C
     */
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node B = x.right;

        // Perform rotation
        x.right = y;
        y.left = B;

        // Update heights (order matters: y first, then x)
        updateHeight(y);
        updateHeight(x);

        return x;  // New root of this subtree
    }

    /**
     * LEFT ROTATION (for RR case)
     *
     *     x                  y
     *    / \                / \
     *   A   y      →       x   C
     *      / \            / \
     *     B   C          A   B
     */
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node B = y.left;

        // Perform rotation
        y.left = x;
        x.right = B;

        // Update heights (order matters: x first, then y)
        updateHeight(x);
        updateHeight(y);

        return y;  // New root of this subtree
    }

    /**
     * Rebalances the tree at the given node
     * Determines which rotation to apply based on balance factors
     */
    private Node rebalance(Node node) {
        if (node == null) {
            return null;
        }

        int bf = balanceFactor(node);

        // Left Heavy (BF > 1)
        if (bf > 1) {
            // Left-Right case
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);  // Convert to LL
            }
            // Left-Left case
            return rotateRight(node);
        }

        // Right Heavy (BF < -1)
        if (bf < -1) {
            // Right-Left case
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);  // Convert to RR
            }
            // Right-Right case
            return rotateLeft(node);
        }

        // Already balanced
        return node;
    }

    // ==================== INSERTION ====================

    /**
     * Public method to insert a value
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Recursive insertion with automatic rebalancing
     */
    private Node insertRec(Node node, int value) {
        // Step 1: Standard BST insertion
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        } else {
            // Duplicate values not allowed
            return node;
        }

        // Step 2: Update height of current node
        updateHeight(node);

        // Step 3: Rebalance if needed
        return rebalance(node);
    }

    // ==================== DELETION ====================

    /**
     * Public method to delete a value
     */
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    /**
     * Recursive deletion with automatic rebalancing
     */
    private Node deleteRec(Node node, int value) {
        // Step 1: Standard BST deletion
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Found node to delete

            // Case 1: Leaf node or only one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Node has two children
            // Find inorder successor (smallest in right subtree)
            Node successor = findMin(node.right);
            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }

        // Step 2: Update height
        updateHeight(node);

        // Step 3: Rebalance
        return rebalance(node);
    }

    /**
     * Finds the minimum value node in a subtree
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ==================== SEARCH ====================

    /**
     * Searches for a value in the tree
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

    // ==================== TRAVERSALS ====================

    /**
     * In-order traversal (sorted order)
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
     * Pre-order traversal
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

    // ==================== DISPLAY ====================

    /**
     * Displays the tree structure with heights and balance factors
     */
    public void display() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println("\nTree Structure (value[h=height, bf=balance factor]):");
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.printf("|-----> %d[h=%d, bf=%d]\n",
                    node.value, node.height, balanceFactor(node));
        } else {
            System.out.printf("%d[h=%d, bf=%d]\n",
                    node.value, node.height, balanceFactor(node));
        }

        display(node.left, level + 1);
    }

    /**
     * Checks if the tree is a valid AVL tree
     */
    public boolean isValidAVL() {
        return isValidAVLRec(root);
    }

    private boolean isValidAVLRec(Node node) {
        if (node == null) {
            return true;
        }

        int bf = balanceFactor(node);
        if (Math.abs(bf) > 1) {
            System.out.println("Invalid AVL: Node " + node.value + " has BF = " + bf);
            return false;
        }

        return isValidAVLRec(node.left) && isValidAVLRec(node.right);
    }

    /**
     * Returns height of the tree
     */
    public int getHeight() {
        return height(root);
    }

    // ==================== MAIN METHOD ====================

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== AVL Tree Operations ===");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display Tree");
            System.out.println("5. In-order Traversal");
            System.out.println("6. Pre-order Traversal");
            System.out.println("7. Check if Valid AVL");
            System.out.println("8. Get Height");
            System.out.println("9. Test with Example Data");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertVal = scanner.nextInt();
                    tree.insert(insertVal);
                    System.out.println("Inserted " + insertVal);
                    tree.display();
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteVal = scanner.nextInt();
                    tree.delete(deleteVal);
                    System.out.println("Deleted " + deleteVal);
                    tree.display();
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchVal = scanner.nextInt();
                    boolean found = tree.search(searchVal);
                    System.out.println(searchVal + (found ? " found" : " not found"));
                    break;

                case 4:
                    tree.display();
                    break;

                case 5:
                    tree.inOrderTraversal();
                    break;

                case 6:
                    tree.preOrderTraversal();
                    break;

                case 7:
                    boolean valid = tree.isValidAVL();
                    System.out.println("Tree is " + (valid ? "valid" : "invalid") + " AVL");
                    break;

                case 8:
                    System.out.println("Tree height: " + tree.getHeight());
                    break;

                case 9:
                    System.out.println("Inserting: 10, 20, 30, 40, 50, 25");
                    int[] testData = {10, 20, 30, 40, 50, 25};
                    for (int val : testData) {
                        tree.insert(val);
                        System.out.println("\nAfter inserting " + val + ":");
                        tree.display();
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

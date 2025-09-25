// Problem: Check if a Binary Tree is a Binary Search Tree (BST)
// Difficulty: Easy
// Description:
// A Binary Search Tree (BST) is a binary tree in which for every node:
//   - All values in the left subtree are strictly less than the node's value
//   - All values in the right subtree are strictly greater than the node's value
//   (This is the "strict" BST definition; duplicates are not allowed.)
//
// Tasks:
//   1. Implement a function to verify whether a binary tree is a valid BST using recursion with min/max constraints.
//   2. Implement an alternative function that uses in-order traversal and checks if the sequence is strictly increasing.
//
// Why we use long for min/max bounds instead of int:
//   - We pass sentinel boundary values that must be "outside" the valid integer range. Using Long.MIN_VALUE / Long.MAX_VALUE
//     guarantees any legitimate int node value fits strictly within the first call's bounds.
//   - If we used int and tried to tighten bounds (e.g., node.val - 1 or node.val + 1) we could overflow for Integer.MIN_VALUE
//     or Integer.MAX_VALUE and accidentally accept invalid trees or cause logic errors.
//   - Using long avoids overflow and lets us use exclusive comparisons: min < node.val < max.
//   - Example overflow pitfall with int: if a node has value = Integer.MAX_VALUE and we recurse right with max = Integer.MAX_VALUE,
//     we can't represent a bound strictly greater than that value using int. With long we can keep max as Long.MAX_VALUE safely.
//
// Time Complexity (both approaches): O(n) where n is the number of nodes.
// Space Complexity:
//   - Recursive (min/max) approach: O(h) for call stack where h is tree height.
//   - In-order approach: O(h) for recursion + O(1) extra (we don't store all values, only track previous).
//
// Sample Trees Tested in main():
//   Valid BST:        Invalid (violation in left-right subtree):
//         5                       5
//       /   \                   /   \
//      3     7                 3     7
//     / \   / \               / \   / \
//    2  4  6  8             2  6  6   8   <-- 6 is in left subtree of 5 (should be <5)
//
// Optional Variation (Duplicates):
//   If you want to allow duplicates consistently (e.g., all duplicates on the right), you can adjust the comparison
//   from (val <= min || val >= max) to (val <= min || val > max) or similar. Here we enforce strict ordering.
//
// Run: Just execute the main method; it constructs example trees and prints results.

public class CheckBinarySearchTree {

    // --- Public API (Approach 1: Recursive min/max bounds) ---
    public static boolean isBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE); // Use long sentinels (see header comment)
    }

    // Recursive helper ensuring: min < node.val < max
    private static boolean validate(Node node, long min, long max) {
        if (node == null) {
            return true; // Empty subtree is valid
        }
        // If node's value violates the strict BST property relative to current bounds -> not a BST
        if (node.val <= min || node.val >= max) {
            return false;
        }
        // Left subtree: values must be < node.val; Right subtree: values must be > node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // --- Public API (Approach 2: In-order traversal) ---
    public static boolean isBSTInOrder(Node root) {
        previous = null; // reset static tracker
        return inOrderAndCheck(root);
    }

    // We keep track of the previous visited node's value in in-order traversal; it must be strictly increasing
    private static Integer previous = null; // Using Integer so we can represent an unset state (null). No overflow risk here.

    private static boolean inOrderAndCheck(Node node) {
        if (node == null) return true;
        if (!inOrderAndCheck(node.left)) return false;
        if (previous != null && node.val <= previous) { // Not strictly increasing -> not a BST
            return false;
        }
        previous = node.val;
        return inOrderAndCheck(node.right);
    }

    // --- Node Definition ---
    // Simple binary tree node with int value (fits typical interview constraints). Bounds logic uses long separately.
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) { this.val = val; this.left = left; this.right = right; }
    }

    // --- Demo / Basic Tests ---
    public static void main(String[] args) {
        // Construct a valid BST: 5 / (3,7) / (2,4,6,8)
        Node valid = new Node(5,
                new Node(3,
                        new Node(2),
                        new Node(4)
                ),
                new Node(7,
                        new Node(6),
                        new Node(8)
                )
        );

        // Construct an invalid BST (left-right node violates BST: node 6 in left subtree of 5)
        Node invalid = new Node(5,
                new Node(3,
                        new Node(2),
                        new Node(6) // Violation: should be < 5 but is in left subtree
                ),
                new Node(7,
                        new Node(6),
                        new Node(8)
                )
        );

        // Edge case: Single node tree -> valid
        Node single = new Node(42);

        // Edge case: Tree containing boundary int values
        Node boundary = new Node(0,
                new Node(Integer.MIN_VALUE),
                new Node(Integer.MAX_VALUE)
        );

        System.out.println("Valid (min/max): " + isBST(valid));
        System.out.println("Valid (in-order): " + isBSTInOrder(valid));
        System.out.println("Invalid (min/max): " + isBST(invalid));
        System.out.println("Invalid (in-order): " + isBSTInOrder(invalid));
        System.out.println("Single node (min/max): " + isBST(single));
        System.out.println("Boundary values tree (min/max): " + isBST(boundary));

        // Demonstrate duplicate handling (currently strict):
        Node duplicate = new Node(10,
                new Node(10), // Equal to parent – violates strict BST rule
                new Node(12)
        );
        System.out.println("Duplicate on left (strict, should be false): " + isBST(duplicate));
    }
}

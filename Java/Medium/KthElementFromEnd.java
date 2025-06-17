// KthElementFromEnd.java

/*
 * Problem: Find the Kth element from the end of a Linked List
 * Given a singly linked list, find the Kth node from the end of the list.
 * For example, if the list is 1 -> 2 -> 3 -> 4 -> 5 and K = 2, the result should be 4.
 *
 * Solution: Two-Pointer Approach
 * We can solve this problem in a single pass using two pointers: a 'fast' pointer and a 'slow' pointer.
 * 1. Move the 'fast' pointer K steps ahead from the head of the list.
 * 2. Then, move both 'fast' and 'slow' pointers one step at a time until the 'fast' pointer reaches the end of the list (or its next is null).
 * 3. When the 'fast' pointer reaches the end, the 'slow' pointer will be at the Kth node from the end.
 *
 * This approach works because the 'fast' pointer creates a gap of K-1 nodes between itself and the 'slow' pointer.
 * When the 'fast' pointer reaches the end, the 'slow' pointer will be exactly K nodes behind it,
 * which means it's at the Kth node from the end of the list.
 */

public class KthElementFromEnd {

    public static Node getNthNodeFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            return null; // Handle edge cases
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // If n is greater than the length of the list
                return null;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k1 = 2;
        Node result1 = getNthNodeFromEnd(head, k1);
        System.out.println("The " + k1 + "th element from the end is: " + (result1 != null ? result1.data : "null")); // Expected: 5

        int k2 = 4;
        Node result2 = getNthNodeFromEnd(head, k2);
        System.out.println("The " + k2 + "th element from the end is: " + (result2 != null ? result2.data : "null")); // Expected: 3

        int k3 = 6;
        Node result3 = getNthNodeFromEnd(head, k3);
        System.out.println("The " + k3 + "th element from the end is: " + (result3 != null ? result3.data : "null")); // Expected: 1

        int k4 = 7; // K is greater than list length
        Node result4 = getNthNodeFromEnd(head, k4);
        System.out.println("The " + k4 + "th element from the end is: " + (result4 != null ? result4.data : "null")); // Expected: null

        int k5 = 0; // K is 0
        Node result5 = getNthNodeFromEnd(head, k5);
        System.out.println("The " + k5 + "th element from the end is: " + (result5 != null ? result5.data : "null")); // Expected: null

        // Test with a single node list
        Node singleNodeHead = new Node(100);
        int k6 = 1;
        Node result6 = getNthNodeFromEnd(singleNodeHead, k6);
        System.out.println("The " + k6 + "th element from the end of single node list is: " + (result6 != null ? result6.data : "null")); // Expected: 100
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
} 
// Problem: Binary Search in a Sorted Array
// Difficulty: Easy
// Description:
//   Given a sorted (ascending) array of integers and a target value, return the index of the target if it exists;
//   otherwise return -1.
//   Binary Search cuts the search interval in half each step.
//
// Key Points:
//   - Works ONLY on sorted data.
//   - Time Complexity: O(log n)
//   - Space Complexity: O(1) iterative, O(log n) recursive (due to call stack)
//   - Stable? Not applicable (it does not reorder data).
//
// Why we compute mid as: left + (right - left) / 2
//   - Using (left + right) / 2 can overflow for very large indices (not common in small examples but good habit).
//   - (right - left) is safe as long as right >= left, and adding left back stays within bounds.
//
// Handling Duplicates:
//   - Standard binary search returns any one matching index.
//   - If you need the FIRST occurrence among duplicates, you can tweak the logic (see firstOccurrence method below).
//
// Demo in main(): Shows iterative, recursive, and first-occurrence searches.

import java.util.Arrays;

public class BinarySearchSample {

    /**
     * Iterative binary search.
     * @param arr   sorted ascending int array
     * @param target value to find
     * @return index of target or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Overflow-safe midpoint
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // Target is in right half
            } else {
                right = mid - 1; // Target is in left half
            }
        }
        return -1; // Not found
    }

    /**
     * Recursive binary search wrapper.
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    /**
     * Recursive helper method.
     */
    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1; // Base case: not found
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
        return binarySearchRecursive(arr, target, left, mid - 1);
    }

    /**
     * Variant: Find FIRST occurrence of target in a sorted array with duplicates.
     * If target exists multiple times, returns the lowest index; else -1.
     */
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;      // Record position
                right = mid - 1;   // Continue searching left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Simple test harness
    public static void main(String[] args) {
        int[] data = { -5, -2, 0, 3, 7, 7, 7, 9, 15, 21 };
        System.out.println("Array: " + Arrays.toString(data));

        int target1 = 7;
        int target2 = 4; // Not present

        int idxIter = binarySearch(data, target1);
        int idxRec = binarySearchRecursive(data, target1);
        int idxFirst = firstOccurrence(data, target1);
        int idxMissing = binarySearch(data, target2);

        System.out.println("Target " + target1 + " (iterative) found at index: " + idxIter);
        System.out.println("Target " + target1 + " (recursive) found at index: " + idxRec);
        System.out.println("Target " + target1 + " (first occurrence) index: " + idxFirst);
        System.out.println("Target " + target2 + " (not present) search result: " + idxMissing);

        // Edge cases
        int[] empty = {};
        int[] single = { 42 };
        System.out.println("Empty array search (expect -1): " + binarySearch(empty, 10));
        System.out.println("Single element present (expect 0): " + binarySearch(single, 42));
        System.out.println("Single element absent (expect -1): " + binarySearch(single, 7));
    }
}

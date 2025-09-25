// Problem: Linear Search in an Array
// Difficulty: Easy
// Description:
//   Given an array and a target element, return the index of the target if it exists; otherwise return -1.
//   Linear Search inspects each element from start to finish until it finds a match or reaches the end.
//
// When to use:
//   - Array is small OR unsorted and only a few lookups are needed.
//   - Cost of sorting (for binary search) outweighs repeated scans.
//   - Data structure does not support faster indexed lookup (e.g., simple list, streaming input).
//
// Time Complexity: O(n) worst / average; O(1) best case (if first element matches)
// Space Complexity: O(1)
// Stable: Not applicable (does not reorder elements)
//
// Variants implemented:
//   1. linearSearch(int[] arr, int target) -> first index or -1
//   2. allOccurrences(int[] arr, int target) -> array of all indices (empty array if none)
//   3. linearSearch(T[] arr, T target) generic version using equals
//
// Edge cases covered in main():
//   - Empty array
//   - Single element (present / absent)
//   - Multiple occurrences
//   - Null target for reference type search
//
// Note: For large numbers of lookups, consider using a HashMap / HashSet (average O(1)).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSearchSample {

    /**
     * Linear search on an int array. Returns first index of target or -1.
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1; // Defensive: null array treated as not found
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return immediately on first match
            }
        }
        return -1; // Not found
    }

    /**
     * Returns all indices where target appears in the array.
     * If the target does not appear, returns an empty int array (length 0).
     */
    public static int[] allOccurrences(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[0];
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indices.add(i);
            }
        }
        // Convert List<Integer> to int[]
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }
        return result;
    }

    /**
     * Generic linear search for reference types.
     * Uses == for null check and equals() for content equality.
     * @param arr array of elements (may be null)
     * @param target element to locate (may be null)
     * @param <T> type of elements
     * @return first index of target or -1
     */
    public static <T> int linearSearch(T[] arr, T target) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            T element = arr[i];
            if (target == null) {
                if (element == null) return i; // Match on both null
            } else if (target.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // Demo / Simple Tests
    public static void main(String[] args) {
        int[] nums = { 4, 2, 7, 7, 9, -1, 7 };
        System.out.println("Array: " + Arrays.toString(nums));

        int target1 = 7;
        int target2 = 5; // Not present

        System.out.println("First occurrence of " + target1 + ": " + linearSearch(nums, target1));
        System.out.println("First occurrence of " + target2 + ": " + linearSearch(nums, target2));
        System.out.println("All occurrences of " + target1 + ": " + Arrays.toString(allOccurrences(nums, target1)));

        // Edge cases
        int[] empty = {};
        int[] single = { 42 };
        System.out.println("Empty array search (expect -1): " + linearSearch(empty, 10));
        System.out.println("Single element present (expect 0): " + linearSearch(single, 42));
        System.out.println("Single element absent (expect -1): " + linearSearch(single, 7));

        // Generic reference type examples
        String[] words = { "alpha", null, "gamma", "beta", null };
        System.out.println("String array: " + Arrays.toString(words));
        System.out.println("Find 'gamma' (expect 2): " + linearSearch(words, "gamma"));
        System.out.println("Find null (expect 1): " + linearSearch(words, null));
        System.out.println("Find 'delta' (expect -1): " + linearSearch(words, "delta"));
    }
}

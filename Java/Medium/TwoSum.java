// Problem: Two Sum
// Difficulty: Medium
// Description: Given an array of integers and a target sum, return the indices of the two numbers such that they add up to the target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// Example: nums = [2, 7, 11, 15], target = 9 -> Output: [0, 1]

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No solution found.");
        }
        scanner.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0]; // No solution found
    }
}
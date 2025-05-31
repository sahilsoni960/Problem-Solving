// Problem: Median of Two Sorted Arrays
// Difficulty: Hard
// Description: Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example: nums1 = [1, 3], nums2 = [2] -> Output: 2.0
//          nums1 = [1, 2], nums2 = [3, 4] -> Output: 2.5

import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of first array: ");
        int m = scanner.nextInt();
        int[] nums1 = new int[m];
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.print("Enter the size of second array: ");
        int n = scanner.nextInt();
        int[] nums2 = new int[n];
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
        scanner.close();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
        }
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1; // i is too small
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j - 1]; }
                else if (j == 0) { maxLeft = nums1[i - 1]; }
                else { maxLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums1[i], nums2[j]); }
                return (maxLeft + minRight) / 2.0;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
} 
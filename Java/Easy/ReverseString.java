// Problem: Reverse String
// Difficulty: Easy
// Description: Write a program to reverse a given string using different approaches.
// The program should reverse the order of characters in the string.
// Example: "hello" -> "olleh", "Java Programming" -> "gnimmargorP avaJ"

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        if (input == null) {
            System.out.println("Please enter a valid string.");
        } else {
            System.out.println("Original string: \"" + input + "\"");
            System.out.println("Reversed using StringBuilder: \"" + reverseUsingStringBuilder(input) + "\"");
            System.out.println("Reversed using Two Pointers: \"" + reverseUsingTwoPointers(input) + "\"");
            System.out.println("Reversed using Recursion: \"" + reverseUsingRecursion(input) + "\"");
        }
        scanner.close();
    }

    /**
     * Approach 1: Using StringBuilder's reverse() method
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the StringBuilder
     *
     * @param str the input string to reverse
     * @return the reversed string
     */
    public static String reverseUsingStringBuilder(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Approach 2: Using Two Pointers technique with character array
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the character array
     *
     * @param str the input string to reverse
     * @return the reversed string
     */
    public static String reverseUsingTwoPointers(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Swap characters at left and right positions
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Approach 3: Using Recursion
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) due to recursion stack
     *
     * @param str the input string to reverse
     * @return the reversed string
     */
    public static String reverseUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Take the first character and append it to the end of the reversed substring
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    /**
     * Approach 4: Using iteration from end to start
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the StringBuilder
     *
     * @param str the input string to reverse
     * @return the reversed string
     */
    public static String reverseUsingIteration(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
}

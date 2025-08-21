// Problem: Palindrome Check
// Difficulty: Easy
// Description: Write a program to check if a given string is a palindrome.
// A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward.
// For this implementation, we'll ignore case sensitivity and consider only alphanumeric characters.
// Example: "racecar" -> true, "A man a plan a canal Panama" -> true, "hello" -> false

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();

        if (input == null || input.isEmpty()) {
            System.out.println("Please enter a valid string.");
        } else {
            boolean result = isPalindrome(input);
            System.out.println("\"" + input + "\" is " + (result ? "" : "not ") + "a palindrome.");
        }
        scanner.close();
    }

    /**
     * Checks if a string is a palindrome using two-pointer approach.
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - only using constant extra space
     *
     * @param s the input string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        // Convert to lowercase and keep only alphanumeric characters
        String cleanString = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = cleanString.length() - 1;

        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Alternative approach: Check palindrome without preprocessing
     * This method skips non-alphanumeric characters during comparison
     *
     * @param s the input string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeAlternative(String s) {
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

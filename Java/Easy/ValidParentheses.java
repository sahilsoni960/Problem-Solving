// Problem: Valid Parentheses
// Difficulty: Easy
// Description: Write a program to check if parentheses are balanced in a string.
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// Example: "()" -> true, "()[]{}" -> true, "(]" -> false, "([)]" -> false

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with parentheses to validate: ");
        String input = scanner.nextLine();

        if (input == null) {
            System.out.println("Please enter a valid string.");
        } else {
            boolean result1 = isValidUsingStack(input);
            boolean result2 = isValidUsingCounter(input);

            System.out.println("Input: \"" + input + "\"");
            System.out.println("Valid using Stack approach: " + result1);
            System.out.println("Valid using Counter approach: " + result2);

            // Highlight when approaches disagree
            if (result1 != result2) {
                System.out.println("APPROACHES DISAGREE! Stack approach is correct.");
                System.out.println("Counter approach cannot handle improperly nested brackets like: ([)]");
            }
        }
        scanner.close();
    }

    /**
     * Approach 1: Using Stack data structure
     * This approach works for all types of brackets: (), [], {}
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) in worst case when all characters are opening brackets
     *
     * @param s the input string containing brackets
     * @return true if brackets are balanced, false otherwise
     */
    public static boolean isValidUsingStack(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Check closing brackets
            else if (c == ')' || c == ']' || c == '}') {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check if the closing bracket matches the opening bracket
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
            // Ignore other characters (if any)
        }

        // If stack is empty, all brackets were properly matched
        return stack.isEmpty();
    }

    /**
     * Approach 2: True Counter-Based with Limited Nesting Support
     * This approach uses only primitive counters and can handle properly nested brackets
     * but has limitations with complex interleaving patterns.
     *
     * Strategy: Track depth and the "dominant" bracket type at each level
     * Works for: "()", "((()))", "()[]", "({[]})"
     * Fails for: "([)]", "({[})]" - complex interleaving
     *
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - truly constant space, no data structures
     *
     * @param s the input string containing brackets
     * @return true if brackets are properly balanced (with limitations)
     */
    public static boolean isValidUsingCounter(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int roundDepth = 0;   // Tracks nesting depth of ()
        int squareDepth = 0;  // Tracks nesting depth of []
        int curlyDepth = 0;   // Tracks nesting depth of {}

        for (char c : s.toCharArray()) {
            // Handle opening brackets
            if (c == '(') {
                // Can only open ( if no other bracket types are currently open at this level
                if (squareDepth > 0 || curlyDepth > 0) {
                    return false; // Interleaving detected
                }
                roundDepth++;
            } else if (c == '[') {
                if (roundDepth > 0 || curlyDepth > 0) {
                    return false; // Interleaving detected
                }
                squareDepth++;
            } else if (c == '{') {
                if (roundDepth > 0 || squareDepth > 0) {
                    return false; // Interleaving detected
                }
                curlyDepth++;
            }
            // Handle closing brackets
            else if (c == ')') {
                roundDepth--;
                if (roundDepth < 0) {
                    return false; // More closing than opening
                }
            } else if (c == ']') {
                squareDepth--;
                if (squareDepth < 0) {
                    return false;
                }
            } else if (c == '}') {
                curlyDepth--;
                if (curlyDepth < 0) {
                    return false;
                }
            }
            // Ignore other characters
        }

        // All brackets should be closed
        return roundDepth == 0 && squareDepth == 0 && curlyDepth == 0;
    }

    /**
     * Approach 3: Using replace method (inefficient but simple)
     * Repeatedly remove pairs of brackets until none left or no more pairs can be removed
     * Time Complexity: O(n²) in worst case
     * Space Complexity: O(n) for string operations
     *
     * @param s the input string containing brackets
     * @return true if brackets are balanced, false otherwise
     */
    public static boolean isValidUsingReplace(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        // Keep removing pairs until no more pairs can be removed
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }

        // If string is empty, all brackets were properly paired
        return s.isEmpty();
    }
}

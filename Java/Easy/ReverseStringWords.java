/*
Write a function that takes a string as input and returns a new string with the words in reverse order. Words are defined as sequences of characters separated by spaces.
Example:

Input: "Hello World"

Output: "World Hello"
Input: "  The quick brown fox  "

Output: "fox brown quick The"

 */

public class ReverseStringWords {

    public static void main(String[] agrs) {
        System.out.println(solutionReverse("The quick brown fox"));
        System.out.println(solutionReverse("Hello World"));
    }

    private static String solutionReverse(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }
}

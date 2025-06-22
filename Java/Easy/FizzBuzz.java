/*
 * Problem: FizzBuzz
 * Difficulty: Easy
 * Description: Write a program that prints the numbers from 1 to 100.
 * But for multiples of three, print "Fizz" instead of the number.
 * For the multiples of five, print "Buzz".
 * For numbers which are multiples of both three and five, print "FizzBuzz".
 */

/*
 * Solution: String Concatenation Approach
 * This approach is efficient and easily extensible for new rules.
 * 1. Iterate from 1 to 100.
 * 2. For each number, create an empty string for the output.
 * 3. Check if the number is divisible by 3. If so, append "Fizz" to the string.
 * 4. Check if the number is divisible by 5. If so, append "Buzz" to the string.
 * 5. If the output string is still empty after these checks, it means the number is not a multiple of 3 or 5.
 *    In this case, we print the number itself.
 * 6. Otherwise, we print the output string ("Fizz", "Buzz", or "FizzBuzz").
 *
 * This method avoids complex nested if-else statements and makes adding new conditions
 * (e.g., for multiples of 7) very simple.
 */
public class FizzBuzz {

    /**
     * Prints numbers from 1 to 100, replacing multiples of 3 with "Fizz",
     * multiples of 5 with "Buzz", and multiples of both with "FizzBuzz".
     */
    public static void printFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            String output = "";

            if (i % 3 == 0) {
                output += "Fizz";
            }
            if (i % 5 == 0) {
                output += "Buzz";
            }

            if (output.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(output);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- FizzBuzz Program Output ---");
        printFizzBuzz();
        System.out.println("-----------------------------");
    }
} 
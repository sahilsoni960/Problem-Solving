/*

Write a function that takes two binary numbers represented as strings and returns their sum, also represented as a binary string.

Function Signature:
String solution(String a, String b)

Input:
Two strings a and b, each representing a binary number. The strings consist of characters '0' and '1' only. (1 ≤ |a|, |b| ≤ 10^4)

Output:
A string representing the binary sum of the two input binary numbers.

Example:
Input: a = "1010", b = "1011"

Output: "10101"
Input: a = "0", b = "0"

Output: "0"
Input: a = "111", b = "1"

Output: "1000"
Input: a = "1101", b = "101"

Output: "10010"
 */

public class AddTwoBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(solution("1010", "1011"));
    }


    public static String solution(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum=carry;
            if (i >= 0) {
                sum = sum + (a.charAt(i) - '0');
                i--;
            }

            if (j >= 0) {
                sum = sum + (b.charAt(j) - '0');
                j--;
            }

            carry = sum / 2;
            result.append(sum % 2);

        }

        return result.reverse().toString();
    }
}

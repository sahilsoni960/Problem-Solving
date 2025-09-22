/*
Shift Each Character in String
Given a string, replace each of its characters by the next one in the English alphabet (a→b, b→c, …, z→a).

Example:
Input: "crazy"
Output: "dsbaz"
 */

public class ReplaceEveryCharacterWithNextOne {

    public static void main(String[] args) {
        System.out.println(solution("crazy"));
    }

    public static String solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        for (char c : chars) {

            if (c == 'z') {
                str.append('a');
            } else {
                str.append((char) (c + 1));
            }
        }
        return str.toString();
    }
}
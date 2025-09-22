/*
Check if the given string is a correct variable name.
Rules:
Can only contain letters, digits, and underscores.
Cannot start with a digit.

Example:
Input: "var_1_Int" → true
Input: "qq-q" → false
Input: "2w2" → false
*/

public class ValidateVariableName {

    public static void main(String[] args) {
        String var = "var_1_Int";
        System.out.println(var.matches("[a-zA-Z_][a-zA-Z0-9_]*"));

        var = "qq-q";
        System.out.println(solution(var));

        var = "2w2";
        System.out.println(var.matches("[a-zA-Z_][a-zA-Z0-9_]*"));

    }

    static boolean solution(String name) {

        char first = name.charAt(0);
        if (!Character.isLetter(first) && first != '_') {
            return false;
        }

        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }

        return true;
    }
}

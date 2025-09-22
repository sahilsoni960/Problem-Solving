/*
Divide People into Two Teams
Several people are standing in a row and need to be divided into two teams.
The first person goes into team 1, the second into team 2, the third into team 1 again, and so on.
You are given an array of positive integers (weights).

Return an array of two integers: the total weight of team 1 and team 2.

Example:

Input: [50, 60, 60, 45, 70]

Output: [180, 105]
*/

public class DivideInTwoTeams {

    public static void main(String[] args) {

        int[] input = {50, 60, 60, 45, 70};
        int []totalWeights = result(input);
        System.out.println("Output: [" + totalWeights[0] + ", " + totalWeights[1] + "]");

    }

    private static int[] result(int[] input) {

        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0)
                teamA += input[i];

            else
                teamB += input[i];

        }
        return new int[]{teamA, teamB};
    }

}

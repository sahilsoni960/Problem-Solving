import java.util.Scanner;

public class EvenOddNumber {

    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        // Using 'long' instead of 'int' allows handling very large numbers beyond the range of 'int'.
        long number = scanner.nextLong();

        checkOddEven(number);

    }

    // 'long' is used to support numbers larger than what 'int' can store (int range: -2,147,483,648 to 2,147,483,647).
    static void checkOddEven(long number) {
        if (number % 2 == 0) {
            System.out.println(number + " is an Even number.");
        } else {
            System.out.println(number + " is an Odd number.");
        }
    }
}

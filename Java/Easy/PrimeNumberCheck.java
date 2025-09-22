import java.util.Scanner;

public class PrimeNumberCheck {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = scan.nextInt();

        System.out.println(checkPrimeNumber(num) ? " is a prime number" : " is not a prime number");

    }

    static boolean checkPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

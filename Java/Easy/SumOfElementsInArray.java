import java.util.Scanner;

public class SumOfElementsInArray {

    public static void main(String args[]) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the size of array: ");

            int size = scan.nextInt();
            if (size < 0) {
                System.out.println("Array size cannot be negative.");
                return;
            }

            int[] arr = new int[size];
            int sum = 0;

            if (size > 0) {
                System.out.println("Enter elements of array:");
            }

            for (int n = 0; n < size; n++) {
                if (!scan.hasNextInt()) {
                    System.out.println("Invalid element. Expected an integer.");
                    return;
                }
                arr[n] = scan.nextInt();
                sum = sum + arr[n];
            }

            System.out.println("Sum of elements in array is: " + sum);
        }
    }

}

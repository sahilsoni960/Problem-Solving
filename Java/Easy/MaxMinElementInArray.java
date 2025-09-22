import java.util.Scanner;

public class MaxMinElementInArray {

    public static void main(String[] args) {

        System.out.print("Enter the size of array: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] arr = new int[size];

for(int i = 0; i < size; i++){
    System.out.print("Enter element " + (i + 1) + ": ");
    arr[i] = scanner.nextInt();
}
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println("Minimum element is: " + min);
        System.out.println("Maximum element is: " + max);
    }

}

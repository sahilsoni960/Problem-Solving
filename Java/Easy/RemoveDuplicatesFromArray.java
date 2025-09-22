import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    // Removes duplicates from a non-decreasing (sorted) array in-place and returns the deduplicated array.
    public static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int j = 1; // index to place the next unique element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j - 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return Arrays.copyOf(arr, j);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] unique = removeDuplicates(arr);
        System.out.println(Arrays.toString(unique));
    }
}

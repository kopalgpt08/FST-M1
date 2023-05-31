package activities;

public class Activity4 {
    public static void main(String args[]) {
        int[] arr = {10, 1, 5, 7, 2, 9, 6, 3};
        int n = arr.length;
        System.out.println("Original Array:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println();
        System.out.println("insertion Sort result:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}

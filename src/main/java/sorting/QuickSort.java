package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                int tempo = arr[i];
                arr[i] = arr[j];
                arr[j] = tempo;
                i++;
            }
        }

        int tempo2 = arr[r];
        arr[r] = arr[i];
        arr[i] = tempo2;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {17, 9, 3, 22, 49, 100, 2, 1, 12, 4}; // 3 2 1
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

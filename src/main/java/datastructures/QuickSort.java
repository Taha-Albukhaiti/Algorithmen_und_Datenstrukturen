package datastructures;

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
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                int tempo = arr[i];
                arr[i] = arr[j];
                arr[j] = tempo;
            }
        }

        int tempo2 = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = tempo2;
        return i +1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 22, 49, 100, 2, 1, 12, 4};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

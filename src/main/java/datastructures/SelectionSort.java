package datastructures;

public class SelectionSort {
    public static int[] selectionSort(int[] arry) {

            for (int j = 1; j < (arry.length - 1); j++) {
                if (arry[j - 1] > arry[j]) {
                    int tempo = arry[j - 1];
                    arry[j - 1] = arry[j];
                    arry[j] = tempo;
                }
            }
        return arry;
    }

    public static int[] selectionSortII(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 1; j < arr.length -1; j++) {
                if (arr[i] >= arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }
}
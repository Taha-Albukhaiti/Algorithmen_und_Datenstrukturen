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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }
}
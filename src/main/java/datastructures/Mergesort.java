package datastructures;

import java.util.Arrays;

public class Mergesort {
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] liftArray = new int[n1];
        int[] rechtArray = new int[n2];
        int i, j, k;

        for (i = 0; i < liftArray.length; i++) {
            liftArray[i] = arr[l + i];
        }
        for (j = 0; j < rechtArray.length; j++){
            rechtArray[j] = arr[m + 1 + j];
        }
        i = j = 0;
        k = l;
        while (i < n1 && j < n2){
            if (liftArray[i] <= rechtArray[j]){
                arr[k] = liftArray[i];
                i++;
            } else {
                arr[k] = rechtArray[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = liftArray[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = rechtArray[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 22, 49, 100, 2, 1, 12, 4};
        mergesort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

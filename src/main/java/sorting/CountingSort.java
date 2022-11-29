package sorting;

import java.util.Arrays;

public class CountingSort {
    public static int[] countingSort(int[] a){
        int[] b = new int[a.length + 1];
        int beg = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > beg) beg = a[i];

        beg++;
        int[] c = new int[beg];

        for (int l = 0; l < beg; l++) c[l] = 0;

        for (int i : a) c[i] = c[i] + 1;

        for (int j = 1; j < beg; j++) c[j] = c[j] + c[j-1];

        for (int k = a.length -1; k >= 0; k--){
            b[c[a[k]]] = a[k];
            c[a[k]] = c[a[k]] - 1;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] arr = countingSort(new int[]{3,1, 3, 2, 8, 5, 2});
        Arrays.stream(arr).forEach(System.out::println);
    }
}

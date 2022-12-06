package sorting;

import java.util.Arrays;

public class SelectionSortRekursiv {
    public static void selectionSortRek(int[] arr, int start, int end) {
        int m = start;
        int z = 0;
        for (int i = start + 1; i <= end; i++) {
            z++;
            if (arr[i] > arr[m]) {
                m = i;

            }
        }
        System.out.println("Z: " + z);

        int temp = arr[m];
        arr[m] = arr[end];
        arr[end] = temp;
        if (end - 1 > start) selectionSortRek(arr, start, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        selectionSortRek(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);

    }
}

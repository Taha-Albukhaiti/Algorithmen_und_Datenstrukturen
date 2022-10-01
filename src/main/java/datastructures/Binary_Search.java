package datastructures;

import java.util.List;

public class Binary_Search {
    public static String binary_search(int[] arr, int item) {
        boolean ok = false;
        int length = arr.length;
        int first = 0;
        while (ok != true && first <= length) {
            int mid = (first + length) / 2;
            if (arr[mid] == item) {
                ok = true;
                return String.valueOf(mid);
            } else {
                if (item > arr[mid]) {
                    first = mid + 1;
                } else {
                    length = mid - 1;
                }
            }
        }
        return "Es existiert nicht";
    }
}

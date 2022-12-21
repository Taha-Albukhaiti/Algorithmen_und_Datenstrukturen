package problems;

import java.util.Arrays;

public class Haeufigkeit {
    static String[] arr;

    public String[] haeufigkeit(int[] a) {
        int m = 0;
        arr = new String[a.length];

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (!frequencyII(a[i])) {
                arr[m] = a[i] + " : " + count;
                m++;
            }

        }
        int nulls = 0;
        for (String s : arr) if (s == null) nulls++;
        String[] neuesArray = new String[arr.length - nulls];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                neuesArray[j] = arr[i];
                j++;
            }
        }
        return neuesArray;

    }

    private static boolean frequencyII(int s) {

        for (String str : arr) if (str != null && str.substring(0, 1).equals(String.valueOf(s))) return true;
        return false;
    }


    public static void main(String[] args) {
        Haeufigkeit f = new Haeufigkeit();
        int[] a = {2, 2, 3, 2, 3, 4, 5, 3, 9, 4, 9, 9, 9};
        String[] strings = f.haeufigkeit(a);
        Arrays.stream(strings).forEach(System.out::println);
    }
}

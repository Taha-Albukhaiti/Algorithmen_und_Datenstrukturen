package sorting;

import java.util.Arrays;

public class MaxSum {
    public static int[] maxSum(int[] arr) {
        int[] re = new int[3];
        int anfang = -1;
        int ende = -1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int s = arr[i];
                System.out.println("______________________");
                System.out.println("i = " + i + ", j = " + j + ", s = " + s );
                System.out.println("______________________");
                for (int k = i + 1; k < j; k++) {
                    s += arr[k];
                    System.out.println("i = " + i + ", j = " + j + ", k = " + k + ", s = " + s);
                    if (s > sum) {
                        anfang = i;
                        ende = j;
                        sum = s;
                    }
                }
            }
        }
        re[0] = anfang;
        re[1] = ende;
        re[2] = sum;
        return re;
    }

    public static void main(String[] args) {
        int[] arr = maxSum(new int[]{3, 1, 4, 11, 9, -13, 4});
        Arrays.stream(arr).forEach(System.out::println);
    }
}

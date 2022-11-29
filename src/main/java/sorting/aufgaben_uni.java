package sorting;

import java.util.Objects;

public class aufgaben_uni {
    static String[] stringsWords = new String[]{"qe", "eee", "ww", "qe", "eee", "p", "ww", "eee", "i"};

    public static int largestDistance(int[] arr) {
        int largest = 0;
        int z = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if ((j - i) > largest) {
                        largest = j - i;
                        z = arr[j];
                        //System.out.println("L = " + largest + ", z = " + z);
                    }
                }
            }
        }
        //System.out.println(largest);
        return z;
    }

    public static int distance(String string1, String string2) {
        int largest = 0;
        int k = 0;
        for (int i = 0; i < stringsWords.length; i++) {
            for (int j = 0; j < stringsWords.length; j++) {
                if (Objects.equals(stringsWords[i].equals(string1), stringsWords[j].equals(string2))) {
                    if ((i - j) > largest) {
                        largest = i - j;
                        k = stringsWords[j].indexOf(stringsWords[j]);
                        System.out.println(k + "  ääää");
                    }
                }
            }
        }
        return k;
    }

    public static int frequency(String word) {
        int j = 0;
        for (int i = 0; i < stringsWords.length; i++) {
            if (stringsWords[i].equals(word)) {
                j++;
            }
        }
        return j;
        //return Arrays.stream(stringsWords).sequential().mapToInt((strings) -> strings.equals(word) ? 1 : 0).sum();
    }

    public static double rekl(double start, double ende) {
        double n = ende - start;
        double z = n;
        if (n <= 1) return z;
        for (double k = n; k > 1; k--){
            for (int j = 1; j < n; j++){
                z+= Math.pow(k, j);
            }
        }
        z += rekl(1, 0.5);
        z += rekl(0.25, 0.75);
        z += rekl(0.5, n);
        return z;
    }

    public static void main(String[] args) {
        System.out.println(largestDistance(new int[]{3, 5, 2, 3, 5, 0, 2, 5, 1}));
        System.out.println(rekl(1, 10));
    }
}

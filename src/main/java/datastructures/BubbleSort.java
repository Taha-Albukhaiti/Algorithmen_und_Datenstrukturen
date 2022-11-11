package datastructures;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Sortiere Algorithmus
     * O(n^2)
     * m	i	A	A[i]>A[i+1]	Vertauschen
     * 5	1	(5,3,4,7,3,2)	5>3	ja
     * 2	(3, 5,4,7,3,2)	5>4	ja
     * 3	(3,4,5,7,3,2)	5>7	nein
     * 4	(3,4,5,7,3,2)	7>3	ja
     * 5	(3,4,5,3,7,2)	7>2	ja
     * 4	1	(3,4,5,3,2,7)	3>4	nein
     * 2	(3,4,5,3,2,7)	4>5	nein
     * 3	(3,4,5,3,2,7)	5>3	ja
     * 4	(3,4,3,5,2,7)	5>2	ja
     * 3	1	(3,4,3,2,5,7)	3>4	nein
     * 2	(3,4,3,2,5,7)	4>3	ja
     * 3	(3,3,4,2,5,7)	4>2	ja
     * 2	1	(3,3,2,4,5,7)	3>3	nein
     * 2	(3,3,2,4,5,7)	3>2	ja
     * 1	1	(3,2,3,4,5,7)	3>2	ja
     * (2,3,3,4,5,7)
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int zaehler = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tempo = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempo;
                    zaehler++;
                }
            }
        }
        System.out.println(zaehler);
        return arr;
    }

    /*
    m	i	A	A[i]>A[i+1]	Vertauschen	k
5	1	(4,3,7,2,4,5)	4>3	ja	1
 	2	(3,4,7,2,4,5)	4>7	nein
 	3	(3,4,7,2,4,5)	7>2	ja	3
 	4	(3,4,2,7,4,5)	7>4	ja	4
 	5	(3,4,2,4,7,5)	7>5	ja	5
4	1	(3,4,2,4,5,7)	3>4	nein
 	2	(3,4,2,4,5,7)	4>2	ja	2
 	3	(3,2,4,4,5,7)	4>4	nein
 	4	(3,2,4,4,5,7)	4>5	nein
1	1	(3,2,4,4,5,7)	3>2	ja	1
 	 	(2,3,4,4,5,7)
     */
    public static int[] bubbleSortSchneller(int[] arr) {
        int m = arr.length - 1;
        int k = 0;
        boolean ok;
        int zaehler = 0;
        do {
            ok = false;
            for (int i = 0; i < m; i++) {
                if (arr[i] > arr[i + 1]) {
                    ok = true;
                    k = i;
                    int tempo = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tempo;
                   zaehler++;
                }
            }
            m = k;
        } while (ok);
        System.out.println(zaehler);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = bubbleSort(new int[]{9, 2, 3, 1, 4, 7});
        Arrays.stream(arr).forEach(System.out::println);
    }
}

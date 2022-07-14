package com.taha_albukhaiti.algorithmen_und_datenstrukturen;

public class MinSort {

    public static int[] minSort(int[] array) {
        int length = array.length;
        int minSoFarIndexI;
        int minSoFar;
        int tempo = 0;
        for (int i = 0; i < length; i++) {
            minSoFar = array[i];
            minSoFarIndexI = i;
            System.out.println("Erste Schleife " + array[i]);
            for (int j = i + 1; j < length; j++) {
                if (array[j] < minSoFar) {
                    minSoFar = array[j];
                    minSoFarIndexI = j;
                    System.out.println("Zweite Schleife " + array[j]);
                }
            }

            if (minSoFarIndexI > i) {
                tempo = array[i];
                array[i] = array[minSoFarIndexI];
                array[minSoFarIndexI] = tempo;
            }
        }

        return array;
    }
    public static int[] minSortII(int[] array) {
        int length = array.length;
        int minSoFarIndexI;
        int minSoFar;
        int tempo;
        int i = 0;
        int j ;
        while (true) {
            if (i >= length) break;
            minSoFar = array[i];
            minSoFarIndexI = i;
            j = i + 1;
            while (true){
                if (j >= length)break;
                if (array[j] < minSoFar) {
                    minSoFar = array[j];
                    minSoFarIndexI = j;
                }
                j += 1;
            }
            if (minSoFarIndexI > i) {
                tempo = array[i];
                array[i] = array[minSoFarIndexI];
                array[minSoFarIndexI] = tempo;
            }
            i++;
        }


        return array;
    }

    public static void main(String[] args) {
        int[] arra = {3, 1, 5, 45, 7};
        int[] arra2 = minSortII(arra);

        for (int i = 0; i < arra2.length; i++) {
            System.out.println(arra2[i]);
        }

    }
}

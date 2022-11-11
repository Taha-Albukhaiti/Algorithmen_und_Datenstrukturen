package search;

import java.util.Arrays;

public class SequentiellesSuchen {
    /**
     * index zurückgeben
     *
     * @param arr
     * @param gesuchtesWert
     * @return
     */
    public static int sequentiellesSuchenSortiert(int[] arr, int gesuchtesWert) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length && arr[i] < gesuchtesWert) i++;
        if (i < arr.length && arr[i] == gesuchtesWert) return i;
        else return -1;
    }

    /**
     * Gibt den Index des gesuchten Werts zurück. Iterativ!
     *
     * @param arr
     * @param gesuchtesWert
     * @return
     */
    public static int binaerSuche(int[] arr, int gesuchtesWert) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int i = (l + r) / 2;
            if (arr[i] == gesuchtesWert) return i;
            else if (arr[i] < gesuchtesWert) l = i + 1;
            else r = i;
        }
        return -1;
    }

    public static int binaerSucheFirst(int[] arr, int gesuchtesWert) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length -1;
        while (l < r) {
            int i = (l + r) / 2;
            if (arr[i] < gesuchtesWert) l = i + 1;
            else r = i;
        }
        if (arr[l] == gesuchtesWert) return l;
        else return -1;
    }

    /**
     * Gibt den Index im Array des gesuchten Werts zurück. Rekursiv!
     *
     * @param arr
     * @param gesuchtesWert
     * @param links
     * @param rechts
     * @return
     */
    public static int binaerSucheRekursiv(int[] arr, int gesuchtesWert, int links, int rechts) {
        Arrays.sort(arr);
        if (links >= rechts) return -1;
        int mitte = (links + rechts) / 2;
        if (arr[mitte] == gesuchtesWert) return mitte;
        else if (arr[mitte] < gesuchtesWert)
            return binaerSucheRekursiv(arr, gesuchtesWert, mitte + 1, rechts);
        else return binaerSucheRekursiv(arr, gesuchtesWert, links, mitte);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 17, 11, 2};
        System.out.println(binaerSucheFirst(arr, 5));

    }
}

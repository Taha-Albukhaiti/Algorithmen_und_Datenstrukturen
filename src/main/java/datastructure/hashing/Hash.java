package datastructure.hashing;

import datastructure.heaps.Heap;

import java.util.ArrayList;
import java.util.List;

public class Hash {
    int m = 11;
    private int[] hash = new int[m];

    Hash() {
        for (int i = 0; i < m; i++) {
            hash[i] = 0;
        }
    }

    static int h(int k, int i) {
        return (2 * k % 11 + i) % 11;
    }

    public int insert(int[] arr, int k) {
        int i = 0;
        do {
            int j = h(k, i);
            if (arr[j] == 0) {
                arr[j] = k;
                return j;
            } else {
                i++;
            }
        } while (i == m);
        return 00;
    }

    static List schnitt(int[] a, int[] b) {

        int i = 0;
        int j = 0;
        List<Integer> c = new ArrayList<>();
        while (i < a.length && j <b.length){
            if (a[i] < b[j])
                i = i + 1;
            else if (a[i] > b[j])
                j = j + 1;
            else
                c.add(a[i]);
                i = i + 1;
                j = j + 1;
        }
        return c;
    }

    public static void main(String[] args) {
        Hash hash1 = new Hash();/*
        int a = hash1.insert(hash1.hash, 1);
        int b = hash1.insert(hash1.hash, 16);
        int c = hash1.insert(hash1.hash, 12);
        int d = hash1.insert(hash1.hash, 99);
        int e = hash1.insert(hash1.hash, 2);
        int f = hash1.insert(hash1.hash, 7);
        int l = hash1.insert(hash1.hash, 49);
        System.out.println(a + ", " + b+ ", " + c + ", " + d + ", " + e + ", " + f+ ", " + l);
        */
        List<Integer> c = schnitt(new int[]{2,5,8,3,1,9}, new int[]{111,5,99,3,1,90});
        c.stream().forEach(System.out::println);


    }
}

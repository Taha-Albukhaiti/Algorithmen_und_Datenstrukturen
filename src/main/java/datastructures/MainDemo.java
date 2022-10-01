package datastructures;

import java.util.Arrays;

import static datastructures.Binary_Search.binary_search;
import static datastructures.InsertionSort.insertionSort;
import static datastructures.InsertionSort.*;
import static datastructures.SelectionSort.*;

public class MainDemo {
   public static void main(String[] args) {
        int[] arr = {9, 3, 22, 49, 100};
        int[] arrI = {9, 3, 2, 1, 100};
       // arr = insertionSortAbsteigend(arr);
        int[] arrII = addArrays(arr, arrI);
        selectionSortII(arrII);
        for (int i = 0; i < arrII.length; i++) {
            System.out.print(arrII[i] + "\t");
        }
        System.out.println();
        System.out.println(serachLike(arr, 33));
        System.out.println();
    }
}

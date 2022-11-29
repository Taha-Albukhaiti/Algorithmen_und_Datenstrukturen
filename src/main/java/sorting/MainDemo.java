package sorting;

import static sorting.InsertionSort.*;
import static sorting.SelectionSort.*;

public class MainDemo {
   public static void main(String[] args) {
        int[] arr = {9, 3, 22, 49, 100};
        int[] arrI = {9, 3, 2, 1, 100};
       // arr = insertionSortAbsteigend(arr);
       // int[] arrII = addArrays(arr, arrI);

       for (int i = 0; i < 1000000; i++) {
           
           final long timeStart = System.currentTimeMillis();
           selectionSortII(arrI);
           final long timeEnd = System.currentTimeMillis();
       }


        for (int i = 0; i < arrI.length; i++) {
            System.out.print(arrI[i] + "\t");
        }
        System.out.println();
        System.out.println(serachLike(arr, 33));
        System.out.println();
    }
}

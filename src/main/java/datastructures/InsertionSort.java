package datastructures;

import java.util.stream.IntStream;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        int[] neuesArr = new int[arr.length];
        int item = arr[0];
        int count = 0;

        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] < item){
                item = neuesArr[i];
                count = i;
               // arr -= arr[count] ;
            }
            neuesArr[i] = item;
        }
        return neuesArr;
    }
    public static int[] insertionSortII(int[] arr){
        for (int j = 1; j < arr.length; j++){
            int temp = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > temp){
                arr[i + 1] = arr[i];
                i -= 1;
            }
            arr[i+1] = temp;
        }
        return arr;
    }
    public static int[] insertionSortAbsteigend(int[] arr){
        for (int j = 1; j < arr.length; j++){
            int temp = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] < temp){
                arr[i + 1] = arr[i];
                i -= 1;
            }
            arr[i+1] = temp;
        }
        return arr;
    }
    public static int serachLike(int[] arr, int v){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == v){
                return i;
            }
        }
        return 0;
    }
    public static int[] addArrays(int[] arrI, int[] arrII){
        int[] arrIII = new int[arrI.length];
        for (int i = 0; i < arrI.length; i++){
            arrIII[i] = arrI[i] + arrII[i];
        }
        return arrIII;
    }

}

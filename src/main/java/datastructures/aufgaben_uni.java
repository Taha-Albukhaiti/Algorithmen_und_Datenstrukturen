package datastructures;

public class aufgaben_uni {

    public static int largestDistance(int[] arr){
        int largest = 0;
        int z = arr[0];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    if ((j - i) > largest){
                        largest = j - i;
                        z = arr[j];
                        System.out.println("L = " + largest + ", z = " + z);
                    }
                }
            }
        }
        System.out.println(largest);
        return z;
    }
    public static void main(String[] args) {
        System.out.println(largestDistance(new int[]{3, 5, 2, 3, 5, 0, 2, 5, 1}));
    }
}

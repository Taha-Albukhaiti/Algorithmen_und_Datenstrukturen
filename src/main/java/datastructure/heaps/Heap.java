

package datastructure.heaps;

import java.util.Arrays;

public class Heap {
    private int[] arr;
    int heapSize;

    public Heap(int[] arr) {
        this.arr = arr;
        this.heapSize = arr.length;
        // this.buildMaxHeap();
    }

    private int left(int i) {
        return (2 * i) + 1;
    }

    private int right(int i) {
        return (2 * i) + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    protected void maxHeapify(int i) {// Θ(n log n) Θ(n)
        int l = left(i);
        int r = right(i);
        int max;
        if (l < heapSize && arr[l] > arr[i]) {
            max = l;
        } else {
            max = i;
        }

        if (r < heapSize && arr[r] > arr[max]) {
            max = r;
        }

        if (max != i) {
            swap (arr, max, i);
            maxHeapify(max);
        }

    }

    protected void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int min;
        if (l < heapSize && arr[l] < arr[i]) {
            min = l;
        } else {
            min = i;
        }
        if (r < heapSize && arr[r] < arr[min]) {
            min = r;
        }

        swap(arr, min, i);
        if (min != i) {
            minHeapify(min);
        }

    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    protected void buildMaxHeap() { // O(log n)
        for (int i = (heapSize - 1) / 2; i >= 0; --i) {
            maxHeapify(i);
        }

    }

    protected void buildMinHeap() {
        for (int i = (heapSize - 1) / 2; i >= 0; --i) {
            minHeapify(i);
        }

    }

    protected void heapSort() {
        buildMaxHeap();
        for (int i = arr.length -1; i >= 1; i--) {
            swap(arr, 0, i);
            heapSize--;
            maxHeapify(0);
        }

    }
    protected int search(int x) {
        int i = 0;
        while ((i <= heapSize && arr[i] != x)) i++;
        if (arr[i] == x) return i;
        return 0;
    }

    protected int getSize() {
        return heapSize;
    }


    // ----------- Prioritätswarteschlange -----------
    /**
     *
     * @return
     */
    protected int delete() {
        int max = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        maxHeapify(0);
        return max;
    }

    protected int getMax() {
        return this.arr[0];
    }

    protected int getMin() {
        return arr[arr.length - 1];
    }

    protected void increaseKey(int i, int wert) {
        arr[i] = wert;
        while (i > 1 && arr[parent(i)] < arr[i]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }

    }

    protected void insert(int k) {

        if (heapSize < arr.length) {
            heapSize++;
            arr[heapSize - 1] = 0;
            increaseKey(heapSize - 1, k);
        }else {
            System.out.println("Heap Size ist nicht kleiner als Array.length");
            // wie kann ich
        }
    }


}

class HeapSort {

    public static void main(String[] args) {
        int[] aa = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Heap a = new Heap(aa);
        a.buildMaxHeap();
        Arrays.stream(aa).forEach(System.out::println);
        System.out.println();

        int[] heap = new int[]{4, 1, 12, 2, 16, 11, 13, 14, 8, 7};
        int[] heap2 = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap h = new Heap(heap);
        Heap h2= new Heap(heap2);
        h2.maxHeapify(1);
        //h.buildMaxHeap();
        Arrays.stream(heap2).forEach(System.out::println);
        System.out.println();
        h.heapSort();
        Arrays.stream(heap).forEach(System.out::println);
        System.out.println();
        //h.increaseKey(3, 13);
        //h.delete();
        //h.insert(21);
        //h.maxHeapify(4);
        ///h.maxHeapify(2);

        h.buildMaxHeap();
        Arrays.stream(heap).forEach(System.out::println);
        h.insert(6);

        h.heapSort();
        Arrays.stream(heap).forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}

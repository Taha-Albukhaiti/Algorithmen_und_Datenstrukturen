

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
        if (l < this.heapSize && this.arr[l] > this.arr[i]) {
            max = l;
        } else {
            max = i;
        }

        if (r < this.heapSize && this.arr[r] > this.arr[max]) {
            max = r;
        }

        this.swap(this.arr, max, i);
        if (max != i) {
            this.maxHeapify(max);
        }

    }

    protected void minHeapify(int i) {
        int l = this.left(i);
        int r = this.right(i);
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
        for (int i = (this.heapSize - 1) / 2; i >= 0; --i) {
            this.maxHeapify(i);
        }

    }

    protected void buildMinHeap() {
        for (int i = (this.heapSize - 1) / 2; i >= 0; --i) {
            this.minHeapify(i);
        }

    }

    protected void heapSort() {
        for (int i = heapSize - 1; i >= 1; i--) {
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
        }
    }


}

class HeapSort {

    public static void main(String[] args) {
        int[] heap = new int[]{4, 1, 12, 2, 16, 11, 13, 14, 8, 7};
        Heap h = new Heap(heap);
        //h.increaseKey(3, 13);
        //h.delete();
        //h.insert(21);
        //h.maxHeapify(4);
        h.buildMaxHeap();
        h.insert(6);

        h.heapSort();
        Arrays.stream(heap).forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}

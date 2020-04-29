package alg.sort;

import Test.Utils;

import java.util.Arrays;

public class HeapSort {
    private long comparisons;
    public static void main(String[] args) {
        int[] arr = Utils.generateArr(10_000);
        int[] arr1 = new int[]{5, 4, 7, 2,5,3,6,7,2,8,9,234,2};
        System.out.println(new HeapSort().heapSort(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println(Utils.isSorted(arr));
    }


    public long heapSort(int[] arr) {
        comparisons = 0;
        buildMaxHeap(arr);
        doSort(arr);
        return comparisons;
    }


    private void buildMaxHeap(int[] arr) {
        for (int heapSize = 1; heapSize < arr.length; heapSize++) {
            int currPos = heapSize;
            while (currPos > 0) {
                int parentIndex = (currPos - 1) / 2;
                comparisons++;
                if (arr[currPos] < arr[parentIndex]) break;
                swap(arr, currPos, parentIndex);
                currPos = parentIndex;
            }
        }
    }


    private void doSort(int[] heap) {
        for (int i = 0; i < heap.length - 1; i++) {
            swap(heap, 0, heap.length - 1 - i);
            siftDown(heap, heap.length - i - 1, 0);
        }
        comparisons++;
        if (heap[0] > heap[1]) swap(heap, 0, 1);
    }

    private void siftDown(int[] heap, int length, int pos) {
        if (pos > (length - 2) / 2) return;
        int leftChildPos = pos * 2 + 1;
        int rightChildPos = leftChildPos + 1;

        int siftPos = pos;
        if (rightChildPos < length) {
            comparisons++;
            if (heap[rightChildPos] > heap[siftPos])
                siftPos = rightChildPos;
        }

        comparisons++;
        if (heap[leftChildPos] > heap[siftPos])
            siftPos = leftChildPos;

        if (siftPos == pos) return;

        swap(heap, pos, siftPos);
        siftDown(heap, length, siftPos);
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

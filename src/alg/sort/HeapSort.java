package alg.sort;

import util.Utils;

import java.util.Arrays;

public class HeapSort {
    private long comparisons;
    public static void main(String[] args) {
        int[] arr = Utils.extractArrayFrom(args[0]);
        System.out.println("Comparisons: " + new HeapSort().heapSort(arr));
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

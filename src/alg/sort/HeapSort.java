package alg.sort;

import Test.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;

//todo comparison count
public class HeapSort {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr = Utils.generateArr(1_000_000);
            new HeapSort().heapSort(arr);
            System.out.println(Utils.isSorted(arr));
        }
    }


    private long heapSort(int[] arr) {
        long comparisons = buildMaxHeap(arr);
        comparisons += phase2(arr);
        return comparisons;
    }


    // ok
    private long buildMaxHeap(int[] arr) {
        long comparisons = 0L;
        for (int heapSize = 0; heapSize < arr.length; heapSize++) {
            int currPos = heapSize;
            while (currPos > 0) {
                int parentIndex = (currPos - 1) / 2;
                comparisons++;
                if (arr[currPos] < arr[parentIndex]) break;
                swap(arr, currPos, parentIndex);
                currPos = parentIndex;
            }
        }
        return comparisons;
    }


    private long phase2(int[] heap) {
        long comparisons = 0;
        for (int i = 0; i < heap.length - 1; i++) {
            swap(heap, 0, heap.length - 1 - i);
            siftDown(heap, heap.length - i - 1, 0);
        }

        if (heap[0] > heap[1]) swap(heap, 0, 1);
        return comparisons;
    }

    private long siftDown(int[] heap, int length, int pos) {
        long comparison = 0L;
        int siftPos = getSiftPos(heap, length, pos);
        if (siftPos != pos) {
            swap(heap, pos, siftPos);
            siftDown(heap, length, siftPos);
        }

        return comparison;
    }

    public int getSiftPos(int[] heap, int length, int pos) {
        int leftChildPos = pos * 2 + 1;
        int rightChildPos = leftChildPos + 1;
        if ((pos > (length - 2) / 2)
                || (heap[leftChildPos] < heap[pos]
                && heap[rightChildPos] < heap[pos]))
            return pos;

        if (rightChildPos >= length)
            return leftChildPos;

        return heap[leftChildPos] > heap[rightChildPos] ? leftChildPos : rightChildPos;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

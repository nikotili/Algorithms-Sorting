package alg.sort;

import Test.Utils;

import java.util.Arrays;

//todo comparison count
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 4, 16, 7, 9, 5, 4, 10, 7, 18, 13, 11, 6, 1, 11};
        int[] arr1 = new int[]{5, 4, 7, 2};
        System.out.println(new HeapSort().heapSort(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println(Utils.isSorted(arr));
    }


    public long heapSort(int[] arr) {
        long comparisons = buildMaxHeap(arr);
        comparisons += doSort(arr);
        return comparisons;
    }


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


    private long doSort(int[] heap) {
        long comparisons = 0;
        for (int i = 0; i < heap.length - 1; i++) {
            swap(heap, 0, heap.length - 1 - i);
            comparisons += siftDown(heap, heap.length - i - 1, 0);
        }
        comparisons++;
        if (heap[0] > heap[1]) swap(heap, 0, 1);
        return comparisons;
    }

    private long siftDown(int[] heap, int length, int pos) {
        long comparisons = 0L;
        if (pos > (length - 2) / 2) return comparisons;
        int leftChildPos = pos * 2 + 1;
        int rightChildPos = leftChildPos + 1;

        if (heap[leftChildPos] < heap[pos] && heap[rightChildPos] < heap[pos])
            return ++comparisons;

        int siftPos;
        if (rightChildPos >= length) {
            siftPos = leftChildPos;
        } else {
            comparisons++;
            siftPos = heap[leftChildPos] > heap[rightChildPos]
                    ? leftChildPos
                    : rightChildPos;
        }

        comparisons++;
        swap(heap, pos, siftPos);
        comparisons += siftDown(heap, length, siftPos);

        return comparisons;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

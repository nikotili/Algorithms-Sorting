package alg.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        final int[] arr = {4, 2, 6, 1, 5, 9, 8, 7, 3};
        final int[] arr1 = {4, 2, 6, 1};
        new HeapSort().heapify(arr);
        new HeapSort().phase2(arr);
        System.out.println(Arrays.toString(arr));
    }

    void heapify(int[] arr) {
        for (int heapSize = 0; heapSize < arr.length; heapSize++) {
            int currPos = heapSize;
            while (currPos > 0) {
                int parentIndex = currPos / 2;
                if (arr[currPos] >= arr[parentIndex]) break;
                swap(arr, currPos, parentIndex);
                currPos = parentIndex;
            }
        }
    }

    private void phase2(int[] heap) {
        for (int sortedSize = 0; sortedSize < heap.length; sortedSize++) {
            int sortedArrIndex = heap.length - sortedSize - 1;
            swap(heap, 0, sortedArrIndex);
            int currPos = 0;
            int leftChildIndex;
            int rightChildIndex;
            while (true) {
                leftChildIndex = currPos * 2 + 1;
                rightChildIndex = leftChildIndex + 1;
                if (leftChildIndex >= sortedArrIndex) break;
                if (heap[leftChildIndex] > heap[currPos] && heap[rightChildIndex] > heap[currPos]) break;

                if (rightChildIndex >= sortedArrIndex) {
                    swap(heap, leftChildIndex, currPos);
                    break;
                }

                if (heap[leftChildIndex] < heap[rightChildIndex]) {
                    swap(heap, leftChildIndex, currPos);
                    currPos = leftChildIndex;
                } else {
                    swap(heap, rightChildIndex, currPos);
                    currPos = rightChildIndex;
                }
            }
        }
    }

//    private void percolateDown(int[] heap, int bound, int currPos) {
//        int leftChildIndex = currPos * 2 + 1;
//        int rightChildIndex = leftChildIndex + 1;
//
//        if (leftChildIndex >= bound && rightChildIndex >= bound) return;
//        if (heap[leftChildIndex] > heap[currPos] && heap[rightChildIndex] > heap[currPos]) return;
//
//        if (heap[leftChildIndex] < heap[rightChildIndex]) {
//            swap(heap, leftChildIndex, currPos);
//            percolateDown(heap, bound, leftChildIndex);
//        } else {
//            swap(heap, rightChildIndex, currPos);
//            percolateDown(heap, bound, rightChildIndex);
//        }
//    }


    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

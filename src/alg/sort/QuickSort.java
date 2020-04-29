package alg.sort;

import Test.Utils;

import java.util.Arrays;

// ok
public class QuickSort {

    private long comparisons;

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }

        System.out.println(new QuickSort().quickSort(arr));
        System.out.println(Utils.isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }

    public long quickSort(int[] arr) {
        comparisons = 0;
        quickSort(arr, 0, arr.length - 1);
        return comparisons;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotPos = partition(arr, start, end, Utils.generateRandomInclusive(start, end));

        quickSort(arr, start, pivotPos - 1);
        quickSort(arr, pivotPos + 1, end);
    }

    private int partition(int[] arr, int start, int end, int pivotPos) {
        int pivotVal = arr[pivotPos];
        swap(arr, pivotPos, end);
        int leftPos = start;
        for (int i = start; i < end; i++) {
            comparisons++;
            if (arr[i] < pivotVal) {
                swap(arr, leftPos++, i);
            }
        }
        swap(arr, leftPos, end);
        return leftPos;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

package alg.sort;

import Test.Utils;
// ok
public class QuickSort {
    public static void main(String[] args) {
        final int[] arr = Utils.generateArr(1000);
        System.out.println(new QuickSort().quickSort(arr));
        System.out.println(Utils.isSorted(arr));
    }

    private long quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    long quickSort(int[] arr, int start, int end) {
        if (start >= end) return 0;

        final long[] partitionResult = partition(arr, start, end, Utils.generateRandomInclusive(start, end));
        int pivotPos = (int) partitionResult[0];
        long comparisons = partitionResult[1];

        comparisons += quickSort(arr, start, pivotPos - 1);
        comparisons += quickSort(arr, pivotPos + 1, end);

        return comparisons;
    }

    private long[] partition(int[] arr, int start, int end, int pivotPos) {
        long comparisons = 0L;
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
        return new long[] {leftPos, comparisons};
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

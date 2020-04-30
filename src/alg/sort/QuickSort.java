package alg.sort;

import util.Utils;

import java.security.SecureRandom;

public class QuickSort {

    private long comparisons;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please specify a path");
            return;
        }
        int[] arr = Utils.extractArrayFrom(args[0]);
        System.out.println("Comparisons: " + new QuickSort().quickSort(arr));
    }

    public long quickSort(int[] arr) {
        comparisons = 0;
        quickSort(arr, 0, arr.length - 1);
        return comparisons;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotPos = partition(arr, start, end, randomPivot(start, end));

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

    private static int randomPivot(int start, int end) {
        return new SecureRandom().nextInt(end - start + 1) + start;
    }
}

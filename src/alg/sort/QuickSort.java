package alg.sort;

import Test.Main;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        final int[] arr = {4, 2, 6, 1, 5, 9, 8, 7, 3};
        new QuickSort().sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivotPos = partition(arr, start, end, Main.generateRandomInclusive(start, end));
        sort(arr, start, pivotPos - 1);
        sort(arr, pivotPos + 1, end);
    }

    int partition(int[] arr, int start, int end, int pivotPos) {
        int pivotVal = arr[pivotPos];
        swap(arr, pivotPos, end);
        int leftPos = start;
        for (int i = start; i < end; i++) {
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

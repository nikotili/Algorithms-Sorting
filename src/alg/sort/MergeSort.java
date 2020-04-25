package alg.sort;

import Test.Utils;

public class MergeSort {

    private long comparisons;

    public static void main(String[] args) {
        int[] arr = new int[] {};
    }


    public long mergeSort(int[] arr) {
        arr = doSort(arr);
        return comparisons;
    }

    private int[] doSort(int[] arr) {
        if (arr.length > 1) {
            int[] leftArr = new int[arr.length / 2];
            int[] rightArr = new int[arr.length - leftArr.length];
            for (int i = 0; i < arr.length; i++) {
                if (i < leftArr.length) {
                    leftArr[i] = arr[i];
                } else {
                    rightArr[i - leftArr.length] = arr[i];
                }
            }
            return merge(doSort(leftArr), doSort(rightArr));
        }
        return arr;
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        int[] retArr = new int[leftArr.length + rightArr.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                retArr[k] = leftArr[i++];
            } else {
                retArr[k] = rightArr[j++];
            }
            k++;
        }
        if (i == leftArr.length) {
            while (j < rightArr.length) {
                retArr[k++] = rightArr[j++];
            }
        } else {
            while (i < leftArr.length) {
                retArr[k++] = leftArr[i++];
            }
        }

        return retArr;
    }
}
package alg.sort;

import util.Utils;

public class MergeSort {

    private long comparisons;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please specify a path");
            return;
        }
        int[] arr = Utils.extractArrayFrom(args[0]);
        System.out.println("Comparisons: " + new MergeSort().mergeSort(arr));
    }

    public long mergeSort(int[] arr) {
        comparisons = 0;
        int[] sorted = doSort(arr);
        System.arraycopy(sorted, 0, arr, 0, arr.length);
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
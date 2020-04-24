package alg.sort;

import Test.Utils;

public class InsMergeSort {

    private long comparisons;

    public static void main(String[] args) {
        int[] arr = Utils.generateArr(100);
    }

    public long insMergeSort(int[] arr) {
        arr = doSort(arr);
        return comparisons;
    }

    public int[] doSort(int[] arr) {
        if (arr.length > 5) {
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
        } else insertionSort(arr);
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

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                comparisons++;
                if (key >= arr[j]) {
                    arr[j + 1] = key;
                    break;
                } else {
                    arr[j + 1] = arr[j];
                    arr[j] = key;
                }
            }
        }
    }
}

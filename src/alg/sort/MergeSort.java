package alg.sort;

import Test.Main;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = Main.generateArr(100);
    }

    public int[] sort(int[] arr) {
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
            return merge(sort(leftArr), sort(rightArr));
        }
        return arr;
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        if (leftArr.length == 0) return rightArr;
        if (rightArr.length == 0) return leftArr;
        int[] retArr = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < retArr.length; i++) {
            if (leftIndex >= leftArr.length) {
                retArr[i] = rightArr[rightIndex++];
                continue;
            }
            if (rightIndex >= rightArr.length) {
                retArr[i] = leftArr[leftIndex++];
                continue;
            }
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                retArr[i] = leftArr[leftIndex++];
            } else {
                retArr[i] = rightArr[rightIndex++];
            }
        }
        return retArr;
    }
}
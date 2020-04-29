package alg.sort;

public class InsMergeSort {

    private final int M = 6;
    private long comparisons;

    public long insMergeSort(int[] arr) {
        comparisons = 0;
        doSort(arr);
        return comparisons;
    }

    public int[] doSort(int[] arr) {
        if (arr.length > M) {
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

    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i + 1];
            int j = i;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

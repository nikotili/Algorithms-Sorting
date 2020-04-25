package alg.sort;

import Test.Sorter;
import Test.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class InsMergeSort {

    private long comparisons;
    private final int INSERTION_SORT_THRESHOLD;

    public static void main(String[] args) {
        Map<Integer, List<Long>> data = new LinkedHashMap<>();
        for (int i = 2; i <= 20; i++) {
            int finalI = i;
            Sorter sorter = arr -> new InsMergeSort(finalI).insMergeSort(arr);
            data.put(i, testSortingAlg(sorter, 100, 100000));
        }

        final Map<Integer, Double> collect = data.entrySet()
                .stream()
                .collect(Collectors
                        .groupingBy(Map.Entry::getKey, Collectors
                                .averagingDouble(entry -> entry.getValue()
                                        .stream()
                                        .mapToLong(Long::longValue)
                                        .average()
                                        .getAsDouble())));

        System.out.println(collect);
        System.out.println(collect.entrySet().stream().min(Map.Entry.comparingByValue()));
    }

    public static List<Long> testSortingAlg(Sorter sorter, int arrLength, int times) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            int[] arr = Utils.generateArr(arrLength);
            list.add(sorter.sort(arr));
//            System.out.println(Instant.now().toEpochMilli() - start.toEpochMilli());
        }

        return list;
    }

    public InsMergeSort(int INSERTION_SORT_THRESHOLD) {
        this.INSERTION_SORT_THRESHOLD = INSERTION_SORT_THRESHOLD;
    }

    public long insMergeSort(int[] arr) {
        arr = doSort(arr);
        return comparisons;
    }

    public int[] doSort(int[] arr) {
        if (arr.length > INSERTION_SORT_THRESHOLD) {
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

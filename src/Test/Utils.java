package Test;

import alg.sort.HeapSort;
import alg.sort.InsMergeSort;
import alg.sort.MergeSort;
import alg.sort.QuickSort;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {

    public static void main(String[] args) {
        Sorter quickSorter = arr -> new QuickSort().quickSort(arr);
        Sorter heapSorter = arr -> new HeapSort().heapSort(arr);
        Sorter mergeSorter = arr -> new MergeSort().mergeSort(arr);
        Sorter insMergeSorter = arr -> new InsMergeSort().insMergeSort(arr);

        testSortingAlg(insMergeSorter, 10_000);
    }

    public static int[] generateArr(int length) {
        final SecureRandom secureRandom = new SecureRandom();

        int[] sourceArr = new int[length];

        for (int i = 0; i < sourceArr.length; i++) {
            sourceArr[i] = secureRandom.nextInt(Integer.MAX_VALUE);
        }
        return sourceArr;
    }

    public static int generateRandomInclusive(int from, int to) {
        return new SecureRandom().nextInt(to - from + 1) + from;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static void testSortingAlg(Sorter sorter, int arrLength) {
        final String s = "Comparisons: ";
        for (int i = 0; i < 100; i++) {
            int[] arr = generateArr(arrLength);
//            Instant start = Instant.now();
            System.out.println(sorter.sort(arr));
//            System.out.println(Instant.now().toEpochMilli() - start.toEpochMilli());
        }
    }

    public static boolean isMaxHeap(int arr[], int n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] extractArrayFrom(String path) {
        try {
            final String[] ints = Files.readAllLines(Paths.get(path), Charset.defaultCharset())
                    .get(1)
                    .split(" ");

            return Arrays.stream(ints)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return new int[]{};
    }
}

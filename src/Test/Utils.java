package Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {

    public static int[] generateArr(int length) {
        final SecureRandom secureRandom = new SecureRandom();

        int[] sourceArr = new int[length];

        for (int i = 0; i < sourceArr.length; i++) {
            sourceArr[i] = secureRandom.nextInt(1_000_000);
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

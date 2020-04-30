package util;

import alg.sort.HeapSort;
import alg.sort.InsMergeSort;
import alg.sort.MergeSort;
import alg.sort.QuickSort;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;

public class Utils {

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

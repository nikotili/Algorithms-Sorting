package Test;

import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] generateArr(int length) {
        final SecureRandom secureRandom = new SecureRandom();

        int[] sourceArr = new int[length];

        for (int i = 0; i < sourceArr.length; i++) {
            sourceArr[i] = secureRandom.nextInt();
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
}

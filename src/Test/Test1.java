package Test;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        for (int M = 2; M < 20; M++) {
            double mergeSortComplexity = M * (Math.log(M) / Math.log(2));
            double insertionSortComplexity = (M * (M - 1)) / 4D;
            System.out.println("M = " + M);
            System.out.println("MergeSort = " + mergeSortComplexity);
            System.out.println("InsertionSort = " + insertionSortComplexity);
            System.out.println("Ratio = " + mergeSortComplexity / insertionSortComplexity);
            System.out.println();

        }
    }
}

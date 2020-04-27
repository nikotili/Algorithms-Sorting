package Test;// Java program to generate Worst Case of Merge Sort

import Test.Utils;
import alg.sort.MergeSort;
import alg.sort.QuickSort;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Queue;

class Test1
{
    // Function to join left and right subarray
    static void join(int arr[], int left[], int right[],
                     int l, int m, int r)
    {
        int i;
        for (i = 0; i <= m - l; i++)
            arr[i] = left[i];

        for (int j = 0; j < r - m; j++)
            arr[i + j] = right[j];
    }

    // Function to store alternate elemets in left
    // and right subarray
    static void split(int arr[], int left[], int right[],
                      int l, int m, int r)
    {
        for (int i = 0; i <= m - l; i++)
            left[i] = arr[i * 2];

        for (int i = 0; i < r - m; i++)
            right[i] = arr[i * 2 + 1];
    }

    // Function to generate Worst Case of Merge Sort
    static void generateWorstCase(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;

            // create two auxillary arrays
            int[] left = new int[m - l + 1];
            int[] right = new int[r - m];

            // Store alternate array elements in left
            // and right subarray
            split(arr, left, right, l, m, r);

            // Recurse first and second halves
            generateWorstCase(left, l, m);
            generateWorstCase(right, m + 1, r);

            // join left and right subarray
            join(arr, left, right, l, m, r);
        }
    }

    // driver program
    public static void main (String[] args)
    {
        for (int i = 2; i <= 20; i++) {
            final int[] arr = Utils.generateArr(i);

        new QuickSort().quickSort(arr);
            int n = arr.length;
        generateWorstCase(arr, 0, n - 1);

            System.out.println(new MergeSort().mergeSort(arr));
        }

    }
}

// Contributed by Pramod Kumar

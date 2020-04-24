package alg.sort;

//todo comparison count
public class HeapSort {
    public static void main(String[] args) {

    }


    public long heapSort(int[] arr) {
        long comparisons = buildMaxHeap(arr);
        comparisons += doSort(arr);
        return comparisons;
    }


    private long buildMaxHeap(int[] arr) {
        long comparisons = 0L;
        for (int heapSize = 0; heapSize < arr.length; heapSize++) {
            int currPos = heapSize;
            while (currPos > 0) {
                int parentIndex = (currPos - 1) / 2;
                comparisons++;
                if (arr[currPos] < arr[parentIndex]) break;
                swap(arr, currPos, parentIndex);
                currPos = parentIndex;
            }
        }
        return comparisons;
    }


    private long doSort(int[] heap) {
        long comparisons = 0;
        for (int i = 0; i < heap.length - 1; i++) {
            swap(heap, 0, heap.length - 1 - i);
            comparisons += siftDown(heap, heap.length - i - 1, 0);
        }
        comparisons++;
        if (heap[0] > heap[1]) swap(heap, 0, 1);
        return comparisons;
    }

    private long siftDown(int[] heap, int length, int pos) {
        long comparison = 0L;
        final long[] siftPosResult = getSiftPos(heap, length, pos);
        int siftPos = (int) siftPosResult[0];
        comparison += siftPosResult[1];
        if (siftPos != pos) {
            comparison++;
            swap(heap, pos, siftPos);
            comparison += siftDown(heap, length, siftPos);
        }

        return comparison;
    }


    /**
     *
     * @param heap
     * @param length
     * @param pos
     * @return array which contains the SiftPos at index 0
     * and the number of comparisons at index 1
     */
    public long[] getSiftPos(int[] heap, int length, int pos) {
        int leftChildPos = pos * 2 + 1;
        int rightChildPos = leftChildPos + 1;
        if ((pos > (length - 2) / 2)
                || (heap[leftChildPos] < heap[pos]
                && heap[rightChildPos] < heap[pos]))
            return new long[] {pos, 1};

        if (rightChildPos >= length)
            return new long[] {leftChildPos, 2};

        return heap[leftChildPos] > heap[rightChildPos]
                ? new long[] {leftChildPos, 3}
                : new long[] {rightChildPos, 3};
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

import java.util.Arrays;

import static java.util.Collections.swap;

public class KthLargest {

    int modifiedQuickSort(int[] a, int k) {
        int start = 0, end = a.length;

        while (start < end) {
            int index = partition(a, start, end);

            if (index == (k - 1))
                return a[index];
            if (index > (k - 1))
                end = index - 1;
            else
                start = index + 1;
        }

        return -1;
    }

    private int partition(int[] a, int start, int end) {
        swap(Arrays.asList(a), end, random(start, end));

        //now same as of: int Partition.partition(int[]) method
        int n = end;
        int pivot = a[n - 1];

        int i = 0, p1 = 0, p2 = n - 2;

        while (i <= p2) { //<= confirmed
            if (a[i] > pivot) {
                swap(Arrays.asList(a), i, p2);
                p2--;
            } else if (a[i] < pivot) {
                swap(Arrays.asList(a), i, p1);
                p1++;
                i++;
            } else {
                i++;
            }
        }

        swap(Arrays.asList(a), i, n - 1);
        return i;
    }
}

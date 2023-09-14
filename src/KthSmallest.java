import java.util.List;

import static java.util.Collections.swap;

public class KthLargest {

    int modifiedQuickSort(List<Integer>  a, int k) {
        int start = 0, end = a.size();

        while (start < end) {
            int index = partition(a, start, end);

            if (index == k)
                return a.get(index);
            if (index > k))
                end = index;
            else
                start = index;
        }

        return -1;
    }

    private int partition(List<Integer> a, int start, int end) {
        // swap(a, end, random(start, end));

        //now same as of: int Partition.partition(int[]) method
        int n = end;
        int pivot = a.get(n - 1);

        int
                p = n - 2,
                i = 0;

        while (i <= p) { //<= confirmed
            if (a.get(i) <= pivot) {
                i++;
            } else {
                swap(a, i, p);
                p--;
            }
        }

        swap(a, i, n - 1);
        return i;
    }
}

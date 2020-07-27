import static java.util.Collections.swap;

public class KthLargest {

    int modifiedQuickSort(int[] a, int k) {
        return modifiedQuickSortHelper(a, k, 0, a.length - 1);
    }

    int modifiedQuickSortHelper(int[] a, int k, int start, int end) {
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

    int partition(int[] a, int start, int end) {
        int n = end + 1;
        int randomIndex = random(start, n);
        swap(a, randomIndex, n - 1);

        int R = n - 2;
        int pivot = a[n - 1];

        int i = start;
        while (i <= R) {//<= confirmed
            if (a[i] > pivot) {
                swap(a, i, R);
                R--;
            } else {
                i++;
            }
        }
        swap(a, i, n - 1);

        return i;
    }
}

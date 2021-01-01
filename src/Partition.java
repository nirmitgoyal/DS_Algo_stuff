import java.util.Arrays;

import static java.util.Collections.swap;

public class Partition {

    int partition(int[] a) { //here k/pivot is the last element
        int n = a.length;
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

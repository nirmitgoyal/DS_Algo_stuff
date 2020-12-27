import static java.util.Collections.swap;

public class Partition {

    void partition(int[] a) { //here k/pivot is the last element
        int pivot = a[n - 1];

        int p1 = 0, p2 = n - 2;
        int i = 0;

        while (i <= p2) { //<= confirmed
            if (a[i] < pivot) {
                swap(a, i, p1);
                i++;
                p1++;
            } else if (a[i] > pivot) {
                swap(a, i, p2);
                p2--;
            } else {
                i++;
            }
        }

        swap(a, i, n - 1);
    }
}

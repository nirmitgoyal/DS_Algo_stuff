public class Partition {
    void partition(int[] a) {//here k/pivot is the last element
        int R = n - 2;
        int pivot = a[n - 1];

        int i = 0;
        while (i <= R) {//<= confirmed
            if (a[i] > pivot) {
                swap(a, i, R);
                R--;
            } else {
                i++;
            }
        }
        swap(a, i, n - 1);
    }
}

public class Partition {
    void partition(int[] a) {//here k/pivot is the last element
        int R = n - 2;
        int pivot = a[n - 1];

        while (i <= R) {
            if (a[i] > pivot) {
                swap(i, R);
                R--;
            } else {
                i++;
            }
        }
        swap(i, n - 1);
    }
}

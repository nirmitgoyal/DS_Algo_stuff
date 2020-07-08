public class Partition {
    void partition(int[] a) {//here k/pivot is the last element
        int right = n - 2;
        int pivot = a[n - 1];

        while (i <= right) {
            if (a[i] > pivot) {
                swap(i, right);
                right--;
            } else {
                i++;
            }
        }
        swap(i, n - 1);
    }
}

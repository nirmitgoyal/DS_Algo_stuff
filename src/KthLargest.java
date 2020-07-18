public class KthLargest {

    int modifiedQuickSort(int[] a, int k) {
        return modifiedQuickSortHelper(a, k, 0, n - 1);
    }

    int modifiedQuickSortHelper(int[] a, int k, int start, int end) {
        while (start < end) {
            int index = partition(a, start, end);
            if (index == k)
                return a[k];
            if (index > k)
                modifiedQuickSortHelper(a, k, start, index - 1);
            else
                modifiedQuickSortHelper(a, k, index + 1, end);
        }

        return -1;
    }

    int partition(int[] a, int start, int end) {
        int n = end + 1;
        int randomIndex = random(start, n);
        swap(a, randomIndex, n - 1);

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

        return i;
    }
}

public class FirstAndLastIndicesInSortedArray {
    firstAndLastIndicesOfAnElementInSortedArray(int[] a, int element){
        firstAndLastIndicesOfAnElementInSortedArraHelper(a, 0, n-1,  element, true);
        firstAndLastIndicesOfAnElementInSortedArraHelper(a, 0, n-1,  element, false);
    }

    int firstAndLastIndicesOfAnElementInSortedArraHelper(int[] a, int start, int end, int element, boolean isFirstIndex) {
        while (true) {
            if (isFirstIndex) {
                if (start > end)
                    return -1;

                int mid = (start + end) / 2;

                if (a[mid] == element
                        && (a[mid - 1] != element || mid == 0))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (start > end)
                    return -1;

                int mid = (start + end) / 2;

                if (a[mid] == element
                        && (a[mid + 1] != element || mid == n - 1))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
    }
}

import java.util.Arrays;

public class FirstAndLastIndicesInSortedArray {

    int[] firstAndLastIndicesOfAnElementInSortedArray(int[] a, int element) {
        return Arrays.asList(firstAndLastIndicesOfAnElementInSortedArraHelper(a, 0, n - 1, element, true),
                firstAndLastIndicesOfAnElementInSortedArraHelper(a, 0, n - 1, element, false));
    }

    int firstAndLastIndicesOfAnElementInSortedArraHelper(int[] a, int start, int end, int element, boolean isFirstIndex) {
        while (true) {
            if (isFirstIndex) {
                if (start > end)
                    return -1;

                int mid = (start + end) / 2;

                if (a[mid] == element && (mid == 0 || a[mid - 1] != element))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (start > end)
                    return -1;

                int mid = (start + end) / 2;

                if (a[mid] == element && (mid == n - 1 || a[mid + 1] != element))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
    }
}

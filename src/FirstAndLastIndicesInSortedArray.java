import java.util.Arrays;
import java.util.List;

public class FirstAndLastIndicesInSortedArray {

    List<Integer> firstAndLastIndicesOfAnElementInSortedArray(int[] a, int element) {
        return Arrays.asList(firstAndLastIndicesOfAnElementInSortedArraHelper(true, a, element),
                             firstAndLastIndicesOfAnElementInSortedArraHelper(false, a, element));
    }

    int firstAndLastIndicesOfAnElementInSortedArraHelper(boolean isFirstIndex, int[] a, int element) {
        int start = 0, end = n - 1;

        while (start<end) {
            int mid = (start + end) / 2;

            if (isFirstIndex) {
                if (a[mid] == element && (mid == 0 || a[mid - 1] != element))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (a[mid] == element && (mid == n - 1 || a[mid + 1] != element))
                    return mid;
                else if (a[mid] < element)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}

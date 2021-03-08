public class FirstAndLastOccurence {

    int firstOccurence(int[] a, int target) {
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (target == a[start]) //at the end, start will be the answer, since after finding the target, we are not changing the start
            return start;

        return -1;
    }

    int lastOccurence(int[] a, int target) {
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (target >= a[mid]) //
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (target == a[end]) //
            return end;

        return -1;
    }
}

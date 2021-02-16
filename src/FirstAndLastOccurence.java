public class FirstAndLastOccurence {

    int firstOccurence(int[] a, int target) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (a[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (a[start] == target) return start;
        return -1;
    }

    int lastOccurence(int[] a, int target) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (a[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        if (a[end] == target) return end;
        return -1;
    }
}

public class IsNonDecreasingArray {
    boolean isNonDecreasingArray(int[] a) {
        int faultyIndex = -1;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                if (faultyIndex != -1)
                    return false;
                faultyIndex = i;
            }
        }

        if (faultyIndex == -1
                || faultyIndex == 0
                || faultyIndex == n - 2
                || a[faultyIndex + 2] >= a[faultyIndex]
                || a[faultyIndex - 1] <= a[faultyIndex + 1])//will reach this last or condition only if faultyIndex>faultyIndex+2>=faultyIndex+1
            return true;
        else
            return false;
    }
}

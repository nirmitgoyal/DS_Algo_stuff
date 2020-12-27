public class IsNonDecreasingArray {

    boolean isNonDecreasingArrayGreedy(int[] a) {
        int count = 0; //the number of changes

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                count++;

                if ((i - 2 < 0) || a[i - 2] <= a[i]) //modify a[i-1] on priority
                    a[i - 1] = a[i];
                else
                    a[i] = a[i - 1]; //have to modify a[i]
            }
        }

        return count <= 1;
    }

    /**

            *
        *           *
     *          *

     */
    boolean isNonDecreasingArrayAnalytical(int[] a) {
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
            // see the above graph for 3rd & 4th condition
            return true;
        else
            return false;
    }
}

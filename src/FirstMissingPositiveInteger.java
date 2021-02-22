import static utils.Utils.isSafe;

public class FirstMissingPositiveInteger {

//https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time
    int firstMissingPositiveInteger(int[] a) { // -2, 4, 1, 0, 9 -> 2
        for (int i = 0; i < n; i++) {
            int correctIndex = a[i] - 1;
            while (isSafe(a[i], n) && a[i] != a[correctIndex]) //while elements are not in their correct position, put them in their correct position
                swap(a, i, correctIndex);
        }

        for (int i = 0; i < n; i++)
            if (a[i] != i + 1)
                return i + 1;

        return n + 1;
    }
}


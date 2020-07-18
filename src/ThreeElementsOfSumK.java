import java.util.ArrayList;

public class ThreeElementsOfSumK {

    ArrayList<Element> ThreeElementsOfSumKSpaceOptimized(int[] a, int k) {
        ArrayList<Element> ans = new ArrayList<>();

        a.sort();
        for (int i = 0; i < n; i++) {
            ans.add(TwoElementsOfSumKSpaceOptimized(a, k, i));
        }

        return ans;
    }

    private Element TwoElementsOfSumKSpaceOptimized(int[] a, int k, int i) {
        int start = i, end = n - 1;

        while (start < end) {
            int sum = a[start] + a[end] + a[i];

            if (sum == k) {
                return new Element(a[start], e, a[end]);
                start++;
                end--;
            } else if (sum < k)
                start++;
            else
                end--;
        }
    }

    class Element {
        int e1, e2, e3;
    }
}

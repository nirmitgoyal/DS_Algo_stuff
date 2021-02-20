import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeElementsOfSumK {
    List<Element> result = new ArrayList<>();

    void ThreeElementsOfSumKSpaceOptimized(List<Integer> a, int k) {
        Collections.sort(a);

        for (int i = 0; i < n; i++)
            TwoElementsOfSumKSpaceOptimized(a, k, i);
    }

    private void TwoElementsOfSumKSpaceOptimized(List<Integer> a, int k, int startIndex) {
        int
                low = startIndex + 1,
                high = n - 1;

        while (low < high) {
            int sum = a[startIndex] + a[low] + a[high]; // a[startIndex] is always a fixed element

            if (sum == k) {
                result.add(new Element(a[startIndex], a[low], a[high]));
                low++;
                high--;
            } else if (sum < k) {
                low++;
            } else {
                high--;
            }
        }
    }

    class Element {
        int e1, e2, e3;
    }
}

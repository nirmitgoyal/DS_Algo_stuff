import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeElementsOfSumK {

    List<Element> ThreeElementsOfSumKSpaceOptimized(List<Integer> a, int k) {
        List<Element> result = new ArrayList<>();

        Collections.sort(a);

        for (int i = 0; i < n; i++)
            TwoElementsOfSumKSpaceOptimized(i, result, a, k);

        return result;
    }

    private void TwoElementsOfSumKSpaceOptimized(int startIndex, List<Element> result, List<Integer> a, int k) {
        int low = startIndex + 1, high = n - 1;

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

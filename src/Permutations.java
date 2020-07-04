import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.swap;

//n!
public class Permutations {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    void permutations(int[] a) {
        permutationsHelper(a, 0);
    }

    void permutationsHelper(int[] a, int index) {
        if (index == n - 1) {
            ans.add(new ArrayList(Arrays.asList(a)));
            return;
        }

        for (int i = index; i < n; i++) {
            swap(a, i, index);
            permutationsHelper(a, i + 1);
            swap(a, i, index);//backtrack
        }
    }
}

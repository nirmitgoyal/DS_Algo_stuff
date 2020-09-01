import java.util.ArrayList;

import static java.util.Collections.swap;

//n!
public class Permutations {

    void permutations(int[] a) {
        ArrayList<int[]> result = new ArrayList<>();
        permutationsHelper(result, a, 0);
    }

    void permutationsHelper(ArrayList<int[]> result, int[] a, int index) {
        int n = a.length;

        if (index == n - 1) {
            result.add(a);
            return;
        }

        for (int i = index; i < n; i++) {
            swap(a, i, index);
            permutationsHelper(result, a, (i + 1));
            swap(a, i, index); //backtrack
        }
    }
}

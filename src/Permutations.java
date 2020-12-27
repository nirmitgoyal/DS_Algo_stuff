import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.swap;

//n!
public class Permutations {

    void permutations(int[] a) {
        ArrayList<int[]> result = new ArrayList<>();
        permutationsHelper(0, a, result);
    }

    void permutationsHelper(int index, int[] a, ArrayList<int[]> result) {
        int n = a.length;

        if (index == n - 1) {
            result.add(a);
            return;
        }

        for (int i = index; i < n; i++) {
            swap(Arrays.asList(a), i, index);
            permutationsHelper((i + 1), a, result); //i+1 coz we are fixing i now
            swap(Arrays.asList(a), i, index); //backtrack
        }
    }
}

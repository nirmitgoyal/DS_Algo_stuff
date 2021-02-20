import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

//n!
public class Permutations {
    List<int[]> result = new ArrayList<>();

    void permutations(int[] a) {
        permutationsHelper(a, 0);
    }

    void permutationsHelper(int[] a, int index) {
        int n = a.length;
        if (index == n - 1)
            result.add(a);

        for (int i = index; i < n; i++) {
            swap(Arrays.asList(a), i, index);
            permutationsHelper(a, i + 1); //i+1 coz we are fixing i now
            swap(Arrays.asList(a), i, index); //backtrack
        }
    }
}

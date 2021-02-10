import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

//n!
public class Permutations {
    List<int[]> result = new ArrayList<>();

    void permutations(int[] a) {
        permutationsHelper(0, a);
    }

    void permutationsHelper(int index, int[] a) {
        int n = a.length;
        if (index == n - 1)
            result.add(a);

        for (int i = index; i < n; i++) {
            swap(Arrays.asList(a), i, index);
            permutationsHelper((i + 1), a); //i+1 coz we are fixing i now
            swap(Arrays.asList(a), i, index); //backtrack
        }
    }
}

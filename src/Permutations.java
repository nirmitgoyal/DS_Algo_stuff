import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

//n!
public class Permutations {
    List<int[]> result = new ArrayList<>();
    int[] a;
    int n=a.length;

    void permutations() {
        permutationsHelper(0);
    }

    void permutationsHelper(int index) {
        if (index == n - 1)
            result.add(a);

        for (int i = index; i < n; i++) {
            swap(Arrays.asList(a), i, index);
            permutationsHelper(i + 1); //i+1 coz we are fixing i now
            swap(Arrays.asList(a), i, index); //backtrack
        }
    }
}

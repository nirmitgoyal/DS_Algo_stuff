import java.util.ArrayList;

public class FirstMissingPositiveInteger {

    int firstMissingPositiveInteger(ArrayList<Integer> a) {
        a.add(0);
        int n = a.size();//this is the new size

        while (isSafe(a.get(0), n)) {
            swap(a, 0, a.get(0));
        }
        for (int i = 1; i < n; i++) {
            if (isSafe(a.get(i), n))
                swap(a, i, a.get(i));
        }
        for (int i = 1; i < n; i++) {
            if (i != a.get(i))
                return i;
        }
        return n;
    }
}


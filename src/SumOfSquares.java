import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfSquares {

    Set<Integer> set = new HashSet<>(); //input

    int minElementsRequired(int number) {
        if (number <= 0)
            return 0;
        if (set.contains(number))
            return 1;

        int ans = 1;
        for (int e : set)
            ans = Math.min(ans, minElementsRequired(number - e) + 1);

        return ans;
    }

    Map<Integer, Integer> cache;

    int minElementsRequiredMemo(int number) {
        if (cache.containsKey(number))
            return cache.get(number);

        if (number <= 0)
            return 0;
        if (set.contains(number))
            return 1;

        int ans = 1;
        for (int e : set)
            ans = Math.min(ans, minElementsRequired(number - e) + 1);

        cache.put(number, ans);
        return ans;
    }

}

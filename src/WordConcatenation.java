import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordConcatenation {

    List<String> WordConcatenation(List<String> words) {
        List<String> result = new ArrayList<>();

        Set<String> set = new HashSet<>(words);
        Map<String, Boolean> cache = new HashMap<>(); //optimization over brute force

        for (String word : words)
            if (canForm(word, set, cache))
                result.add(word);

        return result;
    }

    private boolean canForm(String word, Set<String> set, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) //optimization over brute force
            return true; //optimization over brute force

        int n = word.length();
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if (set.contains(prefix) &&
               (set.contains(suffix) || canForm(suffix, set, cache))) { //recurse
                cache.put(word, true); //optimization over brute force
                return true;
            }
        }

        cache.put(word, false); //optimization over brute force
        return false;
    }
}

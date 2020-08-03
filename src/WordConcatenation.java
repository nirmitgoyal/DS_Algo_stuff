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
        Map<String, Boolean> cache = new HashMap<>();//just for caching optimization

        for (String word : words)
            if (canForm(word, set, cache))
                result.add(word);

        return result;
    }

    private boolean canForm(String word, Set<String> set, Map<String, Boolean> cache) {
        if (cache.containsKey(word))//just for caching optimization
            return true;//just for caching optimization

        int n = word.length();
        for (int i = 1; i <= (n - 1); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);

            if (set.contains(prefix) && (set.contains(suffix) || canForm(suffix, set, cache))) {
                cache.put(word, true);//just for caching optimization
                return true;
            }
        }

        cache.put(word, false);//just for caching optimization
        return false;
    }
}

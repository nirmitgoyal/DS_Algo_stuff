import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Contains {

    boolean contains(String text, String pattern) {
        int n = text.length();
        Map<Character, Integer> textMap = new HashMap<>();
        Map<Character, Integer> patternMap = new HashMap<>();

        for (char c : pattern)
            textMap.put(c, (textMap.getOrDefault(c, 0) + 1));

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            int indexOld = i - pattern.length();
            if (Utils.isSafeIndex(indexOld, n)) {
                textMap.put(c, (textMap.get(c) - 1));
                cleanMap(textMap, c);
            }

            textMap.put(c, (textMap.getOrDefault(c, 0) + 1));

            if (Utils.isEqual(textMap, patternMap))//do not override equals method, since we have to implement hashKey too
                return true;
        }
        return false;
    }

    private void cleanMap(Map<Character, Integer> map, char c) {
        if (map.get(c) == 0)
            map.remove(c);
    }
}

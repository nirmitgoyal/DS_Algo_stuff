import java.util.HashMap;
import java.util.Map;

import static utils.Utils.areEqual;
import static utils.Utils.isSafe;

public class Contains {

    boolean contains(String text, String pattern) {
        int n = text.length();
        Map<Character, Integer> textMap = new HashMap<>();
        Map<Character, Integer> patternMap = new HashMap<>();

        for (char c : pattern.toCharArray())
            patternMap.put(c, (patternMap.getOrDefault(c, 0) + 1));

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            int indexOld = i - pattern.length();

            if (isSafe(indexOld, n)) {
                textMap.put(c, (textMap.get(c) - 1));
                removeKeyIfValueIs0(textMap, c);
            }

            textMap.put(c, (textMap.getOrDefault(c, 0) + 1));

            if (areEqual(textMap, patternMap)) //do not override equals method, since we have to implement hashKey too
                return true;
        }

        return false;
    }

    private void removeKeyIfValueIs0(Map<Character, Integer> map, char c) {
        if (map.get(c) == 0)
            map.remove(c);
    }
}

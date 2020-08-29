import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsOfAWordInAString {

    List<Integer> allAnagramsOfAWordInAString(String wordOriginal, String s) {
        char[] word = wordOriginal.toCharArray();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : word)
            map.put(c, (map.getOrDefault(c, 0) + 1));

        for (int i = 0; i < s.length; i++) {
            char c = s.charAt(i);

            int oldCIndex = i - word.length;
            if (Utils.isSafe(oldCIndex, s.length)) {
                char cOld = s.charAt(oldCIndex);
                map.put(cOld, (map.getOrDefault(c, 0) + 1));
                cleanMap(map, cOld);
            }

            map.put(c, (map.getOrDefault(c, 0) - 1));
            cleanMap(map, c);

            if (map.isEmpty())
                result.add(oldCIndex + 1);
        }

        return result;
    }

    private void cleanMap(Map<Character, Integer> map, char c) {
        if (map.get(c) == 0)
            map.remove(c);
    }
}
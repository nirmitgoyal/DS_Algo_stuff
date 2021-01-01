import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsOfAWordInAString {

    List<Integer> allAnagramsOfAWordInAString(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        int n1 = s1.length();
        int n2 = s2.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n1; i++)
            map.put(s1.charAt(i),
                   (map.getOrDefault(s1.charAt(i), 0) + 1));

        for (int i = 0; i < n2; i++) {
            char c = s2.charAt(i);

            //suppress back / add back the character whose count was deceased
            int oldCIndex = i - n1;
            if (Utils.isSafeIndex(oldCIndex, n2)) {
                char cOld = s2.charAt(oldCIndex);
                map.put(cOld, (map.getOrDefault(c, 0) + 1));
                removeKeyIfValueIs0(map, cOld);
            }

            //decease the count
            map.put(c, (map.getOrDefault(c, 0) - 1));
            removeKeyIfValueIs0(map, c);

            //if map is empty, we got an answer
            if (map.isEmpty())
                result.add(oldCIndex + 1);
        }

        return result;
    }

    private void removeKeyIfValueIs0(Map<Character, Integer> map, char c) {
        if (map.get(c) == 0)
            map.remove(c);
    }
}
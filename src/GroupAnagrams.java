import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>(); //Key contains array repr. of the freq. of chars

        for (String s : words)
            map
                .getOrDefault(getHaskKey(s), new ArrayList<>())
                .add(s);

        map.forEach((key, anagrams) -> {
            result.add(anagrams);
        });

        return result;
    }

    private int[] getHaskKey(String s) {
        int[] key = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            key[index]++;
        }

        return key;
    }
}

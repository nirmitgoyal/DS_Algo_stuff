import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>(); //Key contains array repr. of the freq. of chars //array->list of anagrams

        for (String s : words)
            map.getOrDefault(getHashKey(s), new ArrayList<>())
                    .add(s);

        //all the values in the map is the answer
        map.forEach((key, anagrams) -> {
            result.add(anagrams);
        });

        return result;
    }

    private int[] getHashKey(String s) {
        int[] key = new int[26];

        for (char c : s.toCharArray())
            key[c - 'a']++;

        return key;
    }
}

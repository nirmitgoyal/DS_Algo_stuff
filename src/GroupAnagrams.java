import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    List<List<String>> groupAnagrams(ArrayList<String> a) {
        List<List<String>> ans = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>();

        for (String s : a) {
            map.getOrDefault(getHaskKey(s), new ArrayList<String>())
                    .add(s);
        }

        map.forEach((key, value) -> {
            ans.add(value);
        });
        return ans;
    }

    private int[] getHaskKey(String s) {
        int[] key = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            key[index] += 1;
        }

        return key;
    }
}

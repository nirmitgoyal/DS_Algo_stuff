import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinations {
    public static final Map<Integer, List<Character>> MAP = new HashMap<>();
//        1: [],
//        2: ['a', 'b', 'c'],
//        3: ['d', 'e', 'f'],
//        4: ['g', 'h', 'i'],
//        5: ['j', 'k', 'l'],
//        6: ['m', 'n', 'o'],
//        7: ['p', 'q', 'r', 's'],
//        8: ['t', 'u', 'v'],
//        9: ['w', 'x', 'y', 'z'],
//        0: []

    List<String> presentWords(String digits, List<String> words) { // "346", ["dog", "cat", "doc" ]
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(words); //for O(1) searching

        presentWordsHelper("", digits.substring(0), result, set, digits.length());

        return result;
    }

    private void presentWordsHelper(String word, String digits, List<String> result, Set<String> set, int n) {
        if (word.length() == n) {
            if (set.contains(word))
                result.add(word);

            return;
        }

        for (char c : MAP.get(Integer.valueOf(digits.charAt(0))))
            presentWordsHelper(word.concat(String.valueOf(c)), digits.substring(1), result, set, n);
    }
}

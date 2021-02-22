import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<String> result; // "adgj", "adgk", "adg", "adhj", "adhk", "adhl", "adij", ...
    int n;

    void generateWords(int[] digits) { // [2, 3, 4, 5]
        n = digits.length;
        generateWordsHelper(digits, "");
    }

    private void generateWordsHelper(int[] digits, String word) {
        if (word.length() == n) {
            result.add(word);
            return;
        }

        for (char c : MAP.get(digits[0])) //all the chars in this number
            generateWordsHelper(Arrays.copyOfRange(digits, 1, digits.length), word + c);
    }
}

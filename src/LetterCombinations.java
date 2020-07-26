import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LetterCombinations {
    //    Map<Integer, List<Character>> map = {
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
//    }
    static List<String> result = new ArrayList<>();

    void LetterCombinations(String s, List<String> a) {
        Queue<Integer> q = new LinkedList<>(s);
        Set<String> inputSet = new HashSet<>(a);

        LetterCombinationsHelper("", q, inputSet);
    }

    private String LetterCombinationsHelper(String word, Queue<Integer> q, Set<String> inputSet) {
        if (q.isEmpty()) {
            if (inputSet.contains(word))
                return word;
            return null;
        }

        List<Character> charList = map.get(q.poll());
        for (char c : charList) {
            result.add(LetterCombinationsHelper(word + c, q, inputSet));
        }
    }
}

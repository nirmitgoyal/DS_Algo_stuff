import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {
    static final Node ROOT = new Node(new HashMap<>(), 0);

    static List<String> shortestUniquePrefixes(List<String> words) {
        List<String> result = new ArrayList<>();

        buildTrie(words);

        for (String word : words)
            result.add(shortestUniquePrefix(word));

        return result;
    }

    private static void buildTrie(List<String> words) {
        for (String word : words) {
            //assign curr to ROOT, every time
            Node curr = ROOT;

            for (char c : word.toCharArray()) {
                if (!curr.childs.containsKey(c))
                    curr.childs.put(c, new Node(new HashMap<>(), 1));
                else
                    curr.count++;
            }
        }
    }

    private static String shortestUniquePrefix(String word) {
        String shortestUniquePrefix = "";
        Node curr = ROOT;

        for (char c : word.toCharArray()) {
            shortestUniquePrefix += c;
            if (curr.count == 1)
                return shortestUniquePrefix;

            curr = curr.childs.get(c);
        }

        //will never reach here
        return null;
    }

    @AllArgsConstructor
    static
    class Node {
        Map<Character, Node> childs;
        int count;
    }

    public static void main(String[] args) {
        System.out.println(shortestUniquePrefixes(Arrays.asList("zebra", "dog", "duck", "dove")));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {
    static final Node ROOT = new Node();
    static List<String> result = new ArrayList<>();

    static List<String> shortestUniquePrefixes(List<String> words) {
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
                    curr.childs.put(c, new Node());

                curr = curr.childs.get(c);
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
                break;

            curr = curr.childs.get(c);
        }

        return shortestUniquePrefix;
    }

    public static void main(String[] args) {
        System.out.println(shortestUniquePrefixes(Arrays.asList("zebra", "dog", "duck", "dove")));
    }

    static class Node {
        Map<Character, Node> childs;
        int count;

        public Node() {
            childs = new HashMap<>();
            count = 0;
        }
    }
}

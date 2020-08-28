import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {
    private Node root = new Node();

    List<String> ShortestUniquePrefix(List<String> words) {
        List<String> result = new ArrayList<>();

        buildTrie(words);

        for (String word : words)
            result.add(uniquePrefix(word));

        return result;
    }

    private String uniquePrefix(String word) {
        String prefix = "";
        Node node = root;

        for (Character c : word) {
            if (node.count == 1) //at the first iteration, node points to root
                break;

            prefix += c;
            node = node.childs.get(c);
        }

        return prefix;
    }

    private void buildTrie(List<String> words) {
        for (String word : words) {
            Node curr = root;

            for (char c : word) {//though foreach loop not applicable for String
                if (!curr.childs.containsKey(c))
                    curr.childs.put(c, new Node());
            }

            curr.count++;
        }
    }

    public static class Node {
        Map<Character, Node> childs;
        Integer count;

        Node() {
            childs = new HashMap<>();
            count = 0;
        }
    }
}

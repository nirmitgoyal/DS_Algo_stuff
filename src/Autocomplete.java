import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocomplete {

    private Node root = new Node();

    public static class Node {
        private Map<Character, Node> children;
        private boolean isEndOfWord;

        Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    List<String> autocomplete(List<String> words, String prefix) {
        List<String> result = new ArrayList<>();

        buildTrie(words);

        Node curr = root;

        //Reach till the end of prefix
        for (char c : prefix) {
            if (!curr.children.containsKey(c))
                return result;//empty list
            curr = curr.children.get(c);
        }
        //Now we reached till the end of prefix

        dfs(curr, prefix, result);

        return result;
    }

    private void dfs(Node node, String prefix, List<String> result) {
        if (node.isEndOfWord)
            result.add(prefix);

        node.children.forEach((c, e) ->
                dfs(e, prefix + c, result));//maintaining 2 states: Node and prefix
    }

    private void buildTrie(List<String> words) {
        for (String word : words) {
            Node curr = root;

            for (char c : word) {//though foreach loop not applicable for String
                if (!curr.children.containsKey(c))
                    curr.children.put(c, new Node());
            }

            curr.isEndOfWord = true;
        }
    }
}

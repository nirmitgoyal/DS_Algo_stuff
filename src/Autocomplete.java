import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Autocomplete {

    private Node root = new Node();

    List<String> autocomplete(List<String> words, String prefix) {
        List<String> result = new ArrayList<>();

        buildTrie(words);

        Node curr = root;

        //Reach till the end of prefix
        for (char c : prefix) {
            if (!curr.childs.containsKey(c))
                return result;//empty list
            curr = curr.childs.get(c);
        }
        //Now we reached till the end of prefix

        dfs(curr, prefix, result);

        return result;
    }

    private void buildTrie(List<String> words) {
        for (String word : words) {
            Node curr = root;

            for (char c : word) {//though foreach loop not applicable for String
                if (!curr.childs.containsKey(c))
                    curr.childs.put(c, new Node());
            }

            curr.isEndOfWord = true;
        }
    }

    private void dfs(Node node, String prefix, List<String> result) {
        if (node.isEndOfWord)
            result.add(prefix);

        node.childs.forEach((c, e) ->
                dfs(e, prefix + c, result));//maintaining 2 states: Node and prefix
    }

    private void dfsIterative(Node node, String prefix, List<String> result) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(node, prefix));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            Node curr = state.node;
            String currPrefix = state.prefix;

            if (curr.isEndOfWord)
                result.add(currPrefix);

            curr.childs.forEach((c, e) ->
                    stack.push(new State(e, currPrefix + c)));
        }
    }

    public static class Node {
        Map<Character, Node> childs;
        boolean isEndOfWord;

        Node() {
            childs = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private class State {
        Node node;
        String prefix;

        public State(Node node, String prefix) {
        }
    }
}

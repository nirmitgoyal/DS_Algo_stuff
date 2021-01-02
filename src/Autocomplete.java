import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Autocomplete {

    private static final Node ROOT = new Node();

    List<String> autocomplete(List<String> words, String prefix) {
        List<String> result = new ArrayList<>();

        buildTrie(words);

        Node curr = ROOT;
        //Reach till the end of prefix
        for (char c : prefix.toCharArray()) {
            //check even if there is such a prefix in words or not
            if (!curr.childs.containsKey(c))
                return result;//empty list

            curr = curr.childs.get(c);
        }
        //Reached till the end of prefix

        //do a DFS passing the node and prefix, and add to result if the node's isEndOfWord is true
        dfs(curr, prefix, result);

        return result;
    }

    private void buildTrie(List<String> words) {
        for (String word : words) {
            //assign curr to ROOT, every time
            Node curr = ROOT;

            for (char c : word.toCharArray()) {
                if (!curr.childs.containsKey(c))
                    curr.childs.put(c, new Node());
            }

            curr.isEndOfWord = true;
        }
    }

    private void dfs(Node node, String prefix, List<String> result) {
        if (node.isEndOfWord)
            result.add(prefix);

        node.childs.forEach((c, currNode) ->
                dfs(currNode, prefix + c, result));//maintaining 2 states: Node and prefix
    }

    public static class Node {
        Map<Character, Node> childs;
        boolean isEndOfWord;

        Node() {
            childs = new HashMap<>();
            isEndOfWord = false;
        }
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

    @NoArgsConstructor
    @AllArgsConstructor
    private class State {
        Node node;
        String prefix;
    }
}

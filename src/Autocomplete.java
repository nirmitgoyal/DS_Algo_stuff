import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Autocomplete {

  static final List<String> WORDS = new ArrayList<>(); // input

  static final Node ROOT = new Node();
  static List<String> result = new ArrayList<>();

  void autocomplete(String prefix) {
    buildTrie();

    Node curr = ROOT;

    //Reach till the end of prefix
    for (char c : prefix.toCharArray()) {
      //check even if there is such a prefix in WORDS or not
      if (!curr.childs.containsKey(c)) {
        return;//empty list
      }

      curr = curr.childs.get(c);
    }
    //Reached till the end of prefix

    //do a DFS passing the node and prefix, and add to result if the node's isEndOfWord is true
    dfs(curr, prefix);
  }

  private void buildTrie() {
    for (String word : WORDS) {
      //assign curr to ROOT, every time
      Node curr = ROOT;

      for (char c : word.toCharArray()) {
        if (!curr.childs.containsKey(c)) {
          curr.childs.put(c, new Node());
        }

        curr = curr.childs.get(c);
      }

      curr.isEndOfWord = true;
    }
  }

  private void dfs(Node curr, String prefix) {
    if (curr.isEndOfWord) {
      result.add(prefix);
    }

    for (char c : curr.childs.keySet()) {
      dfs(curr.childs.get(c), prefix + c);
    }
  }

  private void dfsIterative(Node node, String prefix) {
    Stack<State> stack = new Stack<>();
    stack.push(new State(node, prefix)); // both params of dfs()

    while (!stack.isEmpty()) {
      State state = stack.pop();
      Node curr = state.node;
      String currPrefix = state.prefix;

      if (curr.isEndOfWord) {
        result.add(currPrefix);
      }

      curr.childs.forEach((c, e) -> stack.push(new State(e, currPrefix + c)));
    }
  }

  @NoArgsConstructor
  public static class Node { //each Node of a trie is just a map of (char it contains)->Node

    Map<Character, Node> childs = new HashMap<>();
    boolean isEndOfWord = false;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  private class State { // for dfsIterative

    Node node;
    String prefix;
  }
}

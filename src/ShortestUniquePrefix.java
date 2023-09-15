import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;

public class ShortestUniquePrefix {

  static final List<String> WORDS = Arrays.asList("zebra", "dog", "duck", "dove"); // input

  static final Node ROOT = new Node();
  static List<String> result = new ArrayList<>();

  static void shortestUniquePrefixes() {
    buildTrie();

    for (String word : WORDS) {
      result.add(shortestUniquePrefix(word));
    }
  }

  private static void buildTrie() {
    for (String word : WORDS) {
      //assign curr to ROOT, every time
      Node curr = ROOT;

      for (char c : word.toCharArray()) {
        if (!curr.childs.containsKey(c)) {
          curr.childs.put(c, new Node());
        }

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

      if (curr.count == 1) {
        break;
      }

      curr = curr.childs.get(c);
    }

    return shortestUniquePrefix;
  }

  public static void main(String[] args) {
    shortestUniquePrefixes();
  }

  @NoArgsConstructor
  static class Node {

    Map<Character, Node> childs = new HashMap<>();
    int count = 0;
  }
}

import static java.lang.Math.max;

import java.util.HashMap;
import java.util.Map;
import models.Node;

//tested
public class RobHousesOnTrees {

  public int rob(Node root) {
    return max(helperMemo(root, true), helperMemo(root, false));
  }

  int helper(Node node, boolean isParentRobbed) {
    if (node == null) {
      return 0;
    }

    if (!isParentRobbed) {
      int robIt = node.data + helper(node.L, true) + helper(node.R, true);
      int doNotRobIt = helper(node.L, false) + helper(node.R, false);

      return max(robIt, doNotRobIt);
    } else {
      return helper(node.L, false) + helper(node.R, false);
    }
  }

  Map<String, Integer> cache = new HashMap<String, Integer>();

  int helperMemo(Node node, boolean isParentRobbed) {
    if (node == null) {
      return 0;
    }

    if (cache.containsKey(String.valueOf(node) + String.valueOf(isParentRobbed))) {
      return cache.get(String.valueOf(node) + String.valueOf(isParentRobbed));
    }

    int ans;
    if (!isParentRobbed) {
      int robIt = node.data + helperMemo(node.L, true) + helperMemo(node.R, true);
      int doNotRobIt = helperMemo(node.L, false) + helperMemo(node.R, false);

      ans = max(robIt, doNotRobIt);
    } else {
      ans = helperMemo(node.L, false) + helperMemo(node.R, false);
    }

    System.out.println(String.valueOf(node) + String.valueOf(isParentRobbed));
    cache.put(String.valueOf(node) + String.valueOf(isParentRobbed), ans);
    return ans;
  }
}

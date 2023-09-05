import lombok.AllArgsConstructor;
import models.Node;

public class CountUniqueValueSubtrees {

  int countUniqueValueSubtrees(Node node) {
    return countUniqueValueSubtreesHelper(node).count;
  }

  private Return countUniqueValueSubtreesHelper(Node node) {
    if (node == null) {
      return new Return(true, 0);
    }

    Return left = countUniqueValueSubtreesHelper(node.L);
    Return right = countUniqueValueSubtreesHelper(node.R);

    if (left.isUniqueValue && right.isUniqueValue
        && (node.L.data == node.data || node.L == null) && (node.R.data == node.data || node.R == null)) {
      return new Return(true, left.count + right.count + 1);
    } else {
      return new Return(false, left.count + right.count);
    }
  }

  @AllArgsConstructor
  class Return {

    boolean isUniqueValue;
    int count;
  }
}

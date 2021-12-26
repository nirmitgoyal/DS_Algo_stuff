import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import models.Node;

public class TreeSerializationDeSerialization {

  //    static String serialized = "";
  String NULL = "#";
  String DELIMITER = "_";

  static String s = "";

  void treeSerialization1(Node root) { //simple
    if (root == null) {
      s += NULL;
      return;
    }

    s += root.data + DELIMITER;
    treeSerialization1(root.L);
    treeSerialization1(root.R);
  }


  String treeSerialization2(Node me) {
    if (me == null) {
      return NULL;
    }

    //NodeLR
    return me.data + DELIMITER + treeSerialization2(me.L) + DELIMITER + treeSerialization2(me.R)
        + DELIMITER;
  }


  Node treeDeSerialization(String s) {
    Queue<String> q = new LinkedList<>(Arrays.asList(s.split(DELIMITER)));

    return treeDeSerializationHelper(q);
  }

  private Node treeDeSerializationHelper(Queue<String> q) {
    String data = q.poll(); //LinkedList returns a null if it is empty

    if (data == null || data == NULL) {
      return null;
    }

    Node me = new Node(Integer.valueOf(data));
    me.L = treeDeSerializationHelper(q);
    me.R = treeDeSerializationHelper(q);

    return me;
  }
}

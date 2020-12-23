import models.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerializationDeSerialization {
//    static String s = "";

    String treeSerialization(Node node) {//or take a static variable and keep appending
        if (node == null)
            return "#";

        return String.valueOf(node.data) + " " + treeSerialization(node.L) + " " + treeSerialization(node.R) + " ";
    }


    Node treeDeSerialization(String s) {
        Queue<String> q = new LinkedList<>();

        q.addAll(Arrays.asList(s.split(" ")));
        return treeDeSerializationHelper(q);
    }

    private Node treeDeSerializationHelper(Queue<String> q) {
        String data = q.poll(); //LinkedList returns a null if it is empty

        if (data == null || data == "#")
            return null;

        Node node = new Node(Integer.valueOf(data));
        node.L = treeDeSerializationHelper(q);
        node.R = treeDeSerializationHelper(q);

        return node;
    }
}

import models.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerializationDeSerialization {
//    static String s = "";

    String treeSerialization(Node me) {//or take a static variable and keep appending
        if (me == null)
            return "#";

        //NodeLR
        return me.data + " " + treeSerialization(me.L) + " " + treeSerialization(me.R) + " ";
    }


    Node treeDeSerialization(String s) {
        Queue<String> q = new LinkedList<>(Arrays.asList(s.split(" ")));

        return treeDeSerializationHelper(q);
    }

    private Node treeDeSerializationHelper(Queue<String> q) {
        String data = q.poll(); //LinkedList returns a null if it is empty

        if (data == null || data == "#")
            return null;

        Node me = new Node(Integer.valueOf(data));
        me.L = treeDeSerializationHelper(q);
        me.R = treeDeSerializationHelper(q);

        return me;
    }
}

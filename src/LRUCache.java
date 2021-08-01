import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head, tail; //node just before tail will be LRU

    LRUCache() {
        capacity = 5;
        map = new HashMap<>();

        //2 dummy nodes
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            update(node);

            return node.value;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;
            update(node);
        } else {
            if (map.size() > capacity) {
                Node LRU = tail.prev;
                remove(LRU);
                map.remove(LRU.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }

    //////////////////////////////////////////////////////////////
    //make these methods first:
    private void add(Node node) { //adds this node just after head
        Node next = head.next;

        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node) { //removes the given node from anywhere
        //these will never throw NPE coz we have 2 dummy nodes initially
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //////////////////////////////////////////////////////////////
    private void update(Node node) {
        remove(node);
        add(node);
    }

    @NoArgsConstructor
    private class Node {
        Integer key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

  private static List<Node> cousins(Node me, Node target) {
    int h = -999;
    int d = -1;

    List<Node> ans = new ArrayList<>();
    if (me == null) {
      return ans;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(me);

    while (q.size() != 0) {
      int count = q.size();
      d++;

      for (int times = 0; times < count; times++) {
        Node curr = q.poll();

        if (target == curr) {
          h = d;
        }

        if (curr.l != null) {
          q.add(curr.l);
        }
        if (curr.r != null) {
          q.add(curr.r);
        }
      }
    }

    q.clear();
    q.add(me);
    d = -1;

    while (q.size() != 0) {
      int count = q.size();
      d++;

      for (int times = 0; times < count; times++) {
        Node curr = q.poll();

        if (h == d && curr != target) {
          ans.add(curr);
        }

        if (curr.l != null) {
          q.add(curr.l);
        }
        if (curr.r != null) {
          q.add(curr.r);
        }
      }
    }

    return ans;
  }

  class Node {

    int data;
    Node l;
    Node r;
  }

//      1 0
//    /   \
//   2 1   3 1
//    \   /   |   \
//    4 2 5 2 7 2  6 2

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();

    Node root = s.new Node();
    root.data = 1;

    Node l = s.new Node();
    l.data = 2;

    Node r = s.new Node();
    r.data = 3;

    Node ll = s.new Node();
    ll.data = 4;

    Node lr = s.new Node();
    lr.data = 5;

    Node rl = s.new Node();
    rl.data = 7;

    Node rr = s.new Node();
    rr.data = 6;

    root.l = l;
    root.r = r;

    l.r = ll;

    r.l = lr;
    r.r = rl;

    ll.l = rr;

    List<Node> ans = cousins(root, lr);
    for (Node node : ans) {
      System.out.println(node.data);
    }
  }

}

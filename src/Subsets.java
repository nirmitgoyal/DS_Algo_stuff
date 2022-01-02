import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currComb = new ArrayList<>();

    subsetsHelper(a, 0, currComb, ans);
    return ans;
  }

  static void subsetsHelper(int[] a, int index, List<Integer> currComb,
      List<List<Integer>> ans) {//index=1
    int n = a.length;
    if (index >= n) {
      return;
    }

    for (int i = index; i < n; i++) {//i=2
      currComb.add(a[i]);
      ans.add(new ArrayList<>(currComb));

      subsetsHelper(a, i + 1, currComb, ans);
      currComb.remove(currComb.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(subsets(new int[]{1, 2, 3}));
  }
}

import static utils.Utils.isEven;

import java.util.HashMap;
import java.util.Map;

public class GeneratePalindrome {

  public static String makePalin(String str) {
    Map<Character, Integer> map = new HashMap<>();

    char[] s = str.toCharArray();

    for (char c : s) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int[] oddTimes = new int[1];
    int[] oddTotal = new int[1];
    char[] oddChar = new char[1];
    boolean[] f = new boolean[1];
    String[] ans = {""}; //cannot use: new String[1]

    //in the 1st iteration, just check
    map.forEach((c, count) -> {
      if (!isEven(count)) {
        oddTimes[0]++;
        oddTotal[0] = count;
        oddChar[0] = c;
      }

      if (oddTimes[0] >= 2) {
        f[0] = true;
      }
    });

    if (f[0]) {
      return null;
    }

    //create string
    map.forEach((c, count) -> {
      if (isEven(count)) {
        for (int times = 0; times < count / 2; times++) {
          ans[0] += c;
        }
      }
    });

    String oddChars = "";
    if (oddTimes[0] == 1) {
      for (int times = 0; times < oddTotal[0]; times++) {
        oddChars += oddChar[0];
      }
    }

    String rev = new StringBuilder(ans[0]).reverse().toString();

    if (oddTimes[0] == 1) {
      ans[0] += oddChars;
    }

    return ans[0] + rev;
  }

  public static void main(String[] args) {
    System.out.println(makePalin(new String("carerac")));//craearc
    System.out.println(makePalin(new String("aab")));
    System.out.println(makePalin(new String("code")));
    System.out.println(makePalin(new String("lol")));
    System.out.println(makePalin(new String("l")));
    System.out.println(makePalin(new String("lo")));
    System.out.println(makePalin(new String("mmmmwwwttttffff")));//ttffmmwwwmmfftt
  }
}

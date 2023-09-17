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

    int oddTimes = 0;
    String oddChar = "";
    boolean f = false;
    String ans = "";

    //in the 1st iteration, just check
    for (char c : map.keySet()) {
      Integer count = map.get(c);
      if (!isEven(count)) {
        oddTimes++;
        oddChar = String.valueOf(c);
      }

      if (oddTimes > 1) {
        f = true;
        break;
      }
    }

    if (f) {
      return "Cannot make Palindrome!";
    }

    //create string
    for (char c : map.keySet()) {
      Integer count = map.get(c);
      for (int times = 0; times < count / 2; times++) {
        ans += c;
      }
    }

    return ans + oddChar + new StringBuilder(ans).reverse();
  }

  public static void main(String[] args) {
    System.out.println(makePalin(new String("carerac")));//craearc
    System.out.println(makePalin(new String("aab")));
    System.out.println(makePalin(new String("code"))); //Cannot make Palindrome!
    System.out.println(makePalin(new String("lol")));
    System.out.println(makePalin(new String("l")));
    System.out.println(makePalin(new String("lo")));
    System.out.println(makePalin(new String("mmmmwwwttttffff")));//ttffmmwwwmmfftt
  }
}

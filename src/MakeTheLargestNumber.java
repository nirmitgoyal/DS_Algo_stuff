import java.util.Arrays;
import java.util.Comparator;

public class MakeTheLargestNumber {

  private class CustomComparator implements Comparator<String> {

    public int compare(String a, String b) {
      String order1 = a + b;
      String order2 = b + a;

      return order2.compareTo(order1);
    }
  }

  public String largestNumber(int[] nums) {
    // Get input integers as strings.
    String[] numsStrings = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numsStrings[i] = String.valueOf(nums[i]);
    }

    // Sort strings according to custom comparator.
    Arrays.sort(numsStrings, new CustomComparator());

    // If, after being sorted, the largest number is `0`, the entire number is zero.
    if (numsStrings[0].equals("0")) {
      return "0";
    }

    // Build largest number from sorted array.
    String ans = "";
    for (String s : numsStrings) {
      ans += s;
    }

    return ans;
  }
}

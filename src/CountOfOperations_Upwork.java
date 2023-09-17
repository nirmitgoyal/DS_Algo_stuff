//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//
//  public static String solution(String S, int K) {
//    String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//
//    Map<String, Integer> map = new HashMap<>();
//    for (int i = 0; i < days.length; i++) {
//      map.put(days[i], i);
//    }
//
//    int newIndex = (map.get(S) + K) % 7;
//
//    return days[newIndex];
//  }
//
//  public static void main(String[] args) {
//    // Test cases
//    System.out.println(solution("Wed", 2));  // Should return "Fri"
//
//    System.out.println(solution("Sat", 23));  // Should return "Mon"
//    System.out.println(solution("Sun", 0)); // Sun
//    System.out.println(solution("Tue", 28)); // Tue
//
//  }
//}
/*
You are given a string S of length N which encodes a non-negative number V in a binary form. Two types of operations may be performed on it to modify its value:
    if V is odd, subtract 1 from it;
    • if V is even, divide it by 2.
    These operations are performed until the value of V becomes 0.
    For example, if string S = "011100", its value V initially is 28. The value of V would change as follows:
    • V = 28, which is even: divide by 2 to obtain 14; • V = 14, which is even: divide by 2 to obtain 7; • V = 7, which is odd: subtract 1 to obtain 6; • V = 6, which is even: divide by 2 to obtain 3; • V = 3, which is odd: subtract 1 to obtain 2; • V = 2, which is even: divide by 2 to obtain 1; • V = 1, which is odd: subtract 1 to obtain 0.
    Seven operations were required to reduce the value of V to 0. Write a function:
class Solution { public int solution (String S); }
that, given a string S consisting of N characters containing a binary representation of the initial value V, returns the number of operations after which its value will become 0.
    Examples:
    1. Given S = "011100", the function should return 7. String S represents the number 28, which becomes 0 after seven operations, as explained above.
    2. Given S = "111", the function should return 5. String S encodes the number V = 7. Its value will change over the following five operations:
    • V = 7, which is odd: subtract 1 to obtain 6;
    • V = 6, which is even: divide by 2 to obtain 3;
    •
    V = 3, which is odd: subtract 1 to obtain 2;
    • V = 2, which is even: divide by 2 to obtain 1;
    • V = 1, which is odd: subtract 1 to obtain 0.
    3. Given S = "1111010101111", the function should return 22.

string S is made only of the characters 'o' and/or '1';
N, which is the length of string S, is an integer within the range [1..1,000,000];
⚫ the binary representation is big-endian, i.e. the first character of string S corresponds to the most significant bit; ⚫ the binary representation may contain leading zeros.
*/
public class Solution {
  public static int solution(String s) {
    int countOfZeros = 0;
    int countOfOnes = 0;
    int operations = 0;

    // Skip leading zeros
    int startIndex = 0;
    while (startIndex < s.length() && s.charAt(startIndex) == '0') {
      startIndex++;
    }

    for (int i = startIndex; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        countOfZeros++;
      } else {
        countOfOnes++;
      }
    }

    operations = countOfZeros + (countOfOnes - 1) * 2 + 1;

    return operations;
  }

  public static void main(String[] args) {
    assert solution("00") == 0 : "Test Case 1 Failed";

    // Test Case 1
    assert solution("011100") == 7 : "Test Case 1 Failed";

    // Test Case 2
    assert solution("111") == 5 : "Test Case 2 Failed";

    // Test Case 3
    assert solution("1111010101111") == 22 : "Test Case 3 Failed";

    // Test Case 4: String with all zeros
    assert solution("0000000") == 0 : "Test Case 4 Failed";

    // Test Case 5: String with leading zeros
    assert solution("000111") == 5 : "Test Case 5 Failed";

    // Test Case 6: String with one '1'
    assert solution("1") == 1 : "Test Case 6 Failed";

    System.out.println("All test cases passed!");
  }
}

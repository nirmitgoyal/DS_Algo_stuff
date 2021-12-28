public class DecodeWays {

  public int numDecodings(String s) {
    //case 1
    if (s.length() == 0) {//an empty string can only be decoded as an empty string -> 1 way
      return 1;
    }

    //case 2
    if (s.charAt(0) == '0') {
      return 0;
    }

    //case 3
    if (s.length() == 1) {
      return 1;
    }

    int count = numDecodings(s.substring(1));

    //case 4
    if (s.length() >= 2
        && ((s.charAt(0) == '1' || s.charAt(0) == '2') && s.charAt(1) <= '6')) {
      count += numDecodings(s.substring(2));
    }

    return count;
  }


  public int numDecodings2(String s) {
    return numDecodingsHelper(s, 0);
  }

  //then covert it to index based
  public int numDecodingsHelper(String s, int index) {
    int n = s.length();

    if (index == n) {//an empty string can only be decoded as an empty string -> 1 way
      return 1;
    }

    if (s.charAt(index) == '0') {
      return 0;
    }

    if (index == n - 1) {
      return 1;
    }

    int count = numDecodingsHelper(s, index + 1);
    if (index < n - 1
        && ((s.charAt(index) == '1' || s.charAt(index) == '2') && s.charAt(index + 1) <= '6')) {
      count += numDecodingsHelper(s, index + 2);
    }

    return count;
  }
}

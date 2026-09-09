import static java.lang.Math.max;

public class LongestCommonSubstring {

  public static int lCSubstring(int[] a1, int[] a2) {
    int[][] t = new int[n1 + 1][n2 + 1];

    for (int r = 1; r < n1 + 1; r++) 
      for (int c = 1; c < n2 + 1; c++) 
        if (a1[r] == a2[c]) 
          t[r][c] = t[r - 1][c - 1] + 1;

    int ans = 0;
    for (int r = 1; r < n1 + 1; r++) 
      for (int c = 1; c < n2 + 1; c++) 
        ans = max(ans, t[r][c]);

    return ans;
  }
}

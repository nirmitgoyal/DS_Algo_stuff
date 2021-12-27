public class MaxRectOf1s {

  public static int maximalRectangle(char[][] a) {
    int rows = a.length;
    int cols = a[0].length;
    int ans = 0;

    for (int r1 = 0; r1 < rows; r1++) {
      for (int r2 = 1; r2 < rows + 1; r2++) {
        for (int c1 = 0; c1 < cols; c1++) {
          for (int c2 = 1; c2 < cols + 1; c2++) {

            int count = 0;
            boolean f = false;
            for (int r = r1; r < r2; r++) {
              for (int c = c1; c < c2; c++) {
                if (a[r][c] == '0') {
                  f = true;
                  break;
                } else {
                  count++;
                }
              }

              if (f) {
                break;
              }
            }

            if (!f) {
              ans = max(ans, count);
            }
          }
        }
      }
    }

    return ans;
  }

}

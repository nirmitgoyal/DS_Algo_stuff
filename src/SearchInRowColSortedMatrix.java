import models.Cell;

public class SearchInRowColSortedMatrix {

  Cell searchInRowColSortedMatrix(int[][] a, int target) {
    int r = 0, c = cols - 1;

    while (r < rows && c >= 0) {
      if (target == a[r][c]) {
        return new Cell(r, c);
      }

      if (target > a[r][c]) {
        r++;
      } else {
        c--;
      }
    }

    return new Cell(-1, -1);
  }
}

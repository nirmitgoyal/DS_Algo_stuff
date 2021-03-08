import models.Cell;

public class SearchInRowColSortedMatrix {

    Cell searchInRowColSortedMatrix(int[][] a, int target) {
        int r = 0, c = cols - 1;

        while (r < rows && c >= 0) {
            int curr = a[r][c];

            if (target == curr)
                return new Cell(r, c);

            if (target > curr)
                r++;
            else
                c--;
        }

        return new Cell(-1, -1);
    }


}

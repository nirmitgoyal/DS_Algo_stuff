import models.Cell;

public class SearchInRowColSortedMatrix {

    Cell searchInRowColSortedMatrix(int[][] a, int target) {
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (target == a[row][col])
                return new Cell(row, col);

            if (target > a[row][col])
                row++;
            else
                col--;
        }

        return new Cell(-1, -1);
    }
}

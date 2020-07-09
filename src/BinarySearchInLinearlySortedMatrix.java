import models.Index;

public class BinarySearchInLinearlySortedMatrix {
    Index BinarySearchInLinearlySortedMatrix(int[][] a, int value) {
        int start = 0, end = rows * cols - 1, mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int row = mid / cols, col = mid % rows;
            if (value == a[row][col])
                return new Index(row, col);
            else if (value > a[row][col])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new Index(-1, -1);
    }
}

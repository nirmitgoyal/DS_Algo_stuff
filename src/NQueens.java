import models.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.fill;
import static utils.Utils.isSafe;

public class NQueens {

    public static List<Cell> placeNQueens(int n) {//this code does not works though //result for 4 is like: [[(0, 1), (1, 3), (2, 0), (3, 2)]
        List<Cell> result = new ArrayList<>();

        Boolean[] allowedRows = new Boolean[n];
        fill(allowedRows, true);
        Boolean[] allowedCols = new Boolean[n];
        fill(allowedCols, true);
        Boolean[] allowedRightDiagonals = new Boolean[2 * n - 1];
        fill(allowedRightDiagonals, true);
        Boolean[] allowedLeftDiagonals = new Boolean[2 * n - 1];
        fill(allowedLeftDiagonals, true);

        return placeNQueensHelper(n, allowedCols, allowedRows, allowedRightDiagonals, allowedLeftDiagonals, result);//send allowedCols for rows(to track rows)
    }

    private static List<Cell> placeNQueensHelper(int n, Boolean[] allowedRows, Boolean[] allowedCols, Boolean[] allowedRightDiagonals, Boolean[] allowedLeftDiagonals, List<Cell> result) {
        if (result.size() == n)
            return result;

        int currRow = result.size();

        for (int currCol = 0; currCol < n; currCol++) {
            if (allowedRows[currCol] && allowedCols[currCol] && (isSafe(currRow + currCol, n) && allowedRightDiagonals[currRow + currCol]) && (isSafe(currRow - currCol, n) && allowedLeftDiagonals[currRow - currCol])) {
                allowedRows[currRow] = false;
                allowedCols[currCol] = false;
                if (isSafe(currRow + currCol, n))
                    allowedRightDiagonals[currRow + currCol] = false;
                if (isSafe(currRow - currCol, n))
                    allowedLeftDiagonals[currRow - currCol] = false;

                result.add(new Cell(currRow, currCol));
                placeNQueensHelper(n, allowedRows, allowedCols, allowedRightDiagonals, allowedLeftDiagonals, result);

                if (result.size() == n)
                    return result;

                //backtrack
                allowedRows[currRow] = true;
                allowedCols[currCol] = true;
                if (isSafe(currRow + currCol, n))
                    allowedRightDiagonals[currRow + currCol] = true;
                if (isSafe(currRow - currCol, n))
                    allowedLeftDiagonals[currRow - currCol] = true;
                result.remove(result.size() - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(placeNQueens(5).toArray()));
    }
}

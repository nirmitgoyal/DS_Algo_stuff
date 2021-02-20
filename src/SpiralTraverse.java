import models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.isSafe;

class TempTest {
    public static final String RIGHT = "RIGHT";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String UP = "UP";

    public static final Map<String, String> NEXT_DIR = new HashMap<>();

    private static void init() {
        NEXT_DIR.put(RIGHT, DOWN);
        NEXT_DIR.put(DOWN, LEFT);
        NEXT_DIR.put(LEFT, UP);
        NEXT_DIR.put(UP, RIGHT);
    }

    static List<Cell> spiralTraverse(Integer[][] m) {
        List<Cell> result = new ArrayList<>();

        if (m == null || m.length == 0)
            return result;

        String currentDir = RIGHT;
        init();

        int rows = m.length, cols = m[0].length;

        int visitsRemaining = rows * cols;
        Cell currentCell = new Cell(0, 0);

        while (visitsRemaining > 0) {
            result.add(currentCell);

            //mark as visited
            m[currentCell.row][currentCell.col] = null;

            CellWithNextDir cellWithNextDir = getNextCellAndDir(currentCell, currentDir, m);

            currentCell = cellWithNextDir.cell;
            currentDir = cellWithNextDir.dir;

            visitsRemaining--;
        }

        return result;
    }

    private static CellWithNextDir getNextCellAndDir(Cell currentCell, String currentDir, Integer[][] m) {
        int rows = m.length, cols = m[0].length;
        int row = currentCell.row, col = currentCell.col;

        if (currentDir == RIGHT) {
            if (isSafe(col + 1, cols) && m[row][col + 1] != null)
                return new CellWithNextDir(new Cell(row, col + 1), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == DOWN) {
            if (isSafe(row + 1, rows) && m[row + 1][col] != null)
                return new CellWithNextDir(new Cell(row + 1, col), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == LEFT) {
            if (isSafe(col - 1, cols) && m[row][col - 1] != null)
                return new CellWithNextDir(new Cell(row, col - 1), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == UP) {
            if (isSafe(row - 1, rows) && m[row - 1][col] != null)
                return new CellWithNextDir(new Cell(row - 1, col), currentDir);
        }

        return new CellWithNextDir(new Cell(row, col + 1), NEXT_DIR.get(currentDir));
    }

    private static class CellWithNextDir {
        Cell cell;
        String dir;

        public CellWithNextDir(Cell cell, String dir) {
            this.cell = cell;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        // Initialize a 2D array
        Integer[][] m = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        List<Cell> cells = spiralTraverse(m);
    }
}

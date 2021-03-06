import lombok.AllArgsConstructor;
import models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.isSafe;

class SpiralTraverse {
    static final String RIGHT = "RIGHT", DOWN = "DOWN",LEFT = "LEFT",UP = "UP";

    static final Map<String, String> NEXT_DIR = new HashMap<>();

    private static void init() {
        NEXT_DIR.put(RIGHT, DOWN);
        NEXT_DIR.put(DOWN, LEFT);
        NEXT_DIR.put(LEFT, UP);
        NEXT_DIR.put(UP, RIGHT);
    }

    static List<Cell> spiralTraverse(Integer[][] m) {
        init();
        List<Cell> result = new ArrayList<>();

        if (m == null || m.length == 0) {
            return result;
        }

        int
                rows = m.length,
                cols = m[0].length;

        //main starting:
        int visitsRemaining = rows * cols;
        Cell currentCell = new Cell(0, 0);
        String currentDir = RIGHT;

        while (visitsRemaining > 0) {
            result.add(currentCell);

            //mark as visited
            m[currentCell.r][currentCell.c] = null;

            CellWithNextDir cellWithNextDir = getNextCellAndDir(m, currentCell, currentDir);

            currentCell = cellWithNextDir.cell;
            currentDir = cellWithNextDir.dir;

            visitsRemaining--;
        }

        return result;
    }

    private static CellWithNextDir getNextCellAndDir(Integer[][] m, Cell currentCell, String currentDir) {
        int
                rows = m.length,
                cols = m[0].length;
        int
                r = currentCell.r,
                c = currentCell.c;

        if (currentDir == RIGHT) {
            int nextC = c + 1;

            if (isSafe(nextC, cols) && m[r][nextC] != null)
                return new CellWithNextDir(new Cell(r, nextC), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == DOWN) {
            int nextR = r + 1;
            if (isSafe(nextR, rows) && m[nextR][c] != null)
                return new CellWithNextDir(new Cell(nextR, c), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == LEFT) {
            int nextC = c - 1;
            if (isSafe(nextC, cols) && m[r][nextC] != null)
                return new CellWithNextDir(new Cell(r, nextC), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }
        if (currentDir == UP) {
            int nextR = r - 1;
            if (isSafe(nextR, rows) && m[nextR][c] != null)
                return new CellWithNextDir(new Cell(nextR, c), currentDir);
        }

        return new CellWithNextDir(new Cell(r, c + 1), NEXT_DIR.get(currentDir));
    }

    @AllArgsConstructor
    private static class CellWithNextDir {
        Cell cell;
        String dir;
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

import lombok.AllArgsConstructor;
import models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.isSafe;

@AllArgsConstructor
class MovingCell {
    Cell cell;
    String dir;
}

class SpiralTraverse {
    static final String RIGHT = "RIGHT", DOWN = "DOWN", LEFT = "LEFT", UP = "UP";
    static final Map<String, String> NEXT_DIR = new HashMap<>();

    private static void init() {
        NEXT_DIR.put(RIGHT, DOWN);
        NEXT_DIR.put(DOWN, LEFT);
        NEXT_DIR.put(LEFT, UP);
        NEXT_DIR.put(UP, RIGHT);
    }

    public static List<Cell> spiralTraverse(Integer[][] m) {
        init();
        List<Cell> result = new ArrayList<>();

        if (m == null || m.length == 0)
            return result;

        int
                rows = m.length,
                cols = m[0].length;

        //main starting:
        int visitsRemaining = rows * cols;
        MovingCell currentMovingCell = new MovingCell(new Cell(0, 0), RIGHT);

        while (visitsRemaining-- > 0) {
            result.add(currentMovingCell.cell);

            //mark as visited
            m[currentMovingCell.cell.r][currentMovingCell.cell.c] = null;

            currentMovingCell = getNextCellAndDir(m, currentMovingCell);
        }

        return result;
    }

    private static MovingCell getNextCellAndDir(Integer[][] m, MovingCell currentMovingCell) {
        int
                rows = m.length,
                cols = m[0].length;

        //
        int
                currR = currentMovingCell.cell.r,
                currC = currentMovingCell.cell.c;
        String currentDir = currentMovingCell.dir;

        if (currentDir == RIGHT) {
            int nextC = currC + 1;

            if (isSafe(nextC, cols) && m[currR][nextC] != null) // keep going in the same direction
                return new MovingCell(new Cell(currR, nextC), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir); // try next direction
        }

        if (currentDir == DOWN) {
            int nextR = currR + 1;

            if (isSafe(nextR, rows) && m[nextR][currC] != null)
                return new MovingCell(new Cell(nextR, currC), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }

        if (currentDir == LEFT) {
            int nextC = currC - 1;

            if (isSafe(nextC, cols) && m[currR][nextC] != null)
                return new MovingCell(new Cell(currR, nextC), currentDir);
            else
                currentDir = NEXT_DIR.get(currentDir);
        }

        if (currentDir == UP) {
            int nextR = currR - 1;

            if (isSafe(nextR, rows) && m[nextR][currC] != null)
                return new MovingCell(new Cell(nextR, currC), currentDir);
        }

        // go to the RIGHT direction
        return new MovingCell(new Cell(currR, currC + 1), NEXT_DIR.get(currentDir));
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

import javafx.scene.control.Cell;

import java.util.ArrayList;

public class IslandSizeWithMaxSameColors {
    public static void main(String[] args) {
    }

    int islandSizeWithMaxSameColors(int[][] m) {
        if (m.length == 0 || m == null)
            return 0;

        int max = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (m[row][col] != -1)//visited
                    max = Math.max(max, DFS(m, row, col));
            }
        }

        return max;
    }

    int DFS(int[][] m, int row, int col) {
        if (m[row][col] == -1)
            return 0;

        m[row][col] = -1;

        int ans = 1;
        for (Cell<Integer, Integer> cell : getNeighbours(row, col)) {
            ans += DFS(m, cell.row, cell.col);
        }

        return ans;
    }

    private ArrayList<Cell<Integer, Integer>> getNeighbours(int row, int col) {
        ArrayList<Cell<Integer, Integer>> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newRow = row + rows[i];
            //newCol

            if (isSafe(newRow, newCol)
                    && m[newRow][newCol] == m[row][col])
                neighbours.add(new Cell(newRow, newCol));
        }
    }
}

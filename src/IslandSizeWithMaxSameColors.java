import models.Cell;
import models.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class IslandSizeWithMaxSameColors {

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
        for (Cell cell : getNeighbours(row, col)) {
            ans += DFS(m, cell.row, cell.col);
        }

        return ans;
    }

    private ArrayList<Cell> getNeighbours(int row, int col) {
        ArrayList<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newRow = row + rows[i];
            //newCol

            if (isSafe(newRow, newCol)
                    && m[newRow][newCol] == m[row][col])
                neighbours.add(new Cell(newRow, newCol));
        }
    }

    int DFSIterative(int[][] m, int row, int col) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(row, col));//1. Push 1st element

        int ans = 0;

        while (!stack.isEmpty()) {//2. Iterate till stack is not empty
            Cell e = stack.pop();
            int r = e.row;
            int c = e.col;

            if (m[r][c] == -1) {
                continue;
            }

            ans++;

            m[r][c] = -1;

            for (Cell cell : getNeighbours(row, col)) {
                stack.push(cell);//3. Push in stack if a neighbour
            }
        }
        return ans;
    }
}

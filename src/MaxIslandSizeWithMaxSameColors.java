import models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxIslandSizeWithMaxSameColors {

    int[] newRows = new int[]{0, 1, 0, -1};
    int[] newCols = new int[]{1, 0, -1, 0};

    int maxIslandSizeWithMaxSameColors(int[][] m) {
        if (m == null || m.length == 0)
            return 0;

        int max = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (m[row][col] != -1)//visited
                    max = Math.max(max, DFS(new Cell(row, col), m, visited));
            }
        }

        return max;
    }

    private int DFS(Cell cell, int[][] m, boolean[][] visited) {
        int row = cell.row, col = cell.col;

        if (m[row][col] == -1)
            return 0;

        m[row][col] = -1;

        int ans = 1;
        for (Cell currentCell : getNeighbours(cell, m)) {
            ans += DFS(currentCell, m, visited);
        }

        return ans;
    }

    private List<Cell> getNeighbours(Cell cell, int[][] m) {
        int row = cell.row, col = cell.col;

        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newRow = row + newRows[i];
            int newCol = col + newCols[i];

            if (isSafe(newRow, rows, newCol, cols)
                    && m[newRow][newCol] == m[row][col])
                neighbours.add(new Cell(newRow, newCol));
        }

        return neighbours;
    }

    int DFSIterative(int[][] m, Cell cell) {
        int row = cell.row, col = cell.col;

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

            for (Cell currentCell : getNeighbours(e, m)) {
                stack.push(currentCell);//3. Push in stack if a neighbour
            }
        }

        return ans;
    }
}

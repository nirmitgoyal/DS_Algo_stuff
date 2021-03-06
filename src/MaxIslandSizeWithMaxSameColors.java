import models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utils.Utils.isSafe;

public class MaxIslandSizeWithMaxSameColors {

    int[][] m;
    int rows=m.length;
    int cols=m[0].length;

    int maxIslandSizeWithMaxSameColors() {
        if (m == null || m.length == 0)
            return 0;

        //
        int max = 0;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (m[row][col] != -1) //if !visited 2 places at which visited is checked)
                    max = Math.max(max, DFS(new Cell(row, col)));

        return max;
    }

    private int DFS(Cell cell) {
        if (m[cell.r][cell.c] == -1) //if visited
            return 0;

        m[cell.r][cell.c] = -1; //visit
        int ans = 1;

        for (Cell neighbour : getNeighbours(cell))
            ans += DFS(neighbour);

        return ans;
    }

    int[] newRows = new int[]{0, 1, 0, -1};
    int[] newCols = new int[]{1, 0, -1, 0};
    private List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newR = cell.r + newRows[i];
            int newC = cell.c + newCols[i];

            if (isSafe(newR, rows) && isSafe(newC, cols)
                    //&& m[newR][newC] != -1 //if !visited //do NOT keep this code
                    && m[newR][newC] == m[cell.r][cell.c]) //logic
                neighbours.add(new Cell(newR, newC));
        }

        return neighbours;
    }

    int DFSIterative(Cell cell) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(cell.r, cell.c));//1. Push 1st element

        int ans = 0;
            while (!stack.isEmpty()) { //2. Iterate till stack is not empty
            Cell curr = stack.pop();

            if (m[curr.r][curr.c] == -1) //if visited
                continue;

            m[curr.r][curr.c] = -1; //visit
            ans++;

            for (Cell neighbour : getNeighbours(curr))
                stack.push(neighbour);//3. Push in stack if a neighbour
        }

        return ans;
    }
}

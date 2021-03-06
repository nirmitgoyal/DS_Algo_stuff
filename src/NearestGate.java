import lombok.AllArgsConstructor;
import models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utils.Utils.isSafe;

public class NearestGate {

    public void wallsAndGates(int[][] m) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (m[r][c] == 0)
                    dfs(new Cell(r, c), 0); // 0 is my distance
            }
        }
    }

    void dfs(Cell cell, int d) {
        if (m[cell.r][cell.c] < d)
            return;

        m[cell.r][cell.c] = d;

        for (Cell neighbour : getNeigbours(cell))
            dfs(neighbour, d + 1);
    }

    List<Cell> getNeigbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newR = cell.r + newRows[i];
            int newC = cell.c + newCols[i];

            if (isSafe(newR, rows) && isSafe(newC, cols)
                    && m[newR][newC] > m[cell.r][cell.c]) //logic
                neighbours.add(new Cell(newR, newC));
        }

        return neighbours;
    }

    void dfsIterative(Cell cell, int d) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(new Cell(cell.r, cell.c), 0));//1. Push 1st element

        while (!stack.isEmpty()) { //2. Iterate till stack is not empty
            State curr = stack.pop();

            if (m[curr.cell.r][curr.cell.c] < curr.d)
                continue;

            m[curr.cell.r][curr.cell.c] = curr.d;

            for (Cell neighbour : getNeigbours(cell))
                stack.push(new State(new Cell(neighbour.r, neighbour.c), curr.d + 1));
        }
    }

    @AllArgsConstructor
    class State {
        Cell cell;
        int d;
    }
}

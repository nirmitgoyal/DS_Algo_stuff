import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Nearest0 {
    //    static int[][] m = new int[][]{
//            {0, 0, 0},
//            {0, 1, 0},
//            {0, 0, 0}};
//static int[][] m = new int[][]{
//        {0, 0, 0},
//        {0, 1, 0},
//        {1, 1, 1}};
    static int[][] m = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};
    int rows = m.length;
    int cols = m[0].length;
    int[] newRows = new int[]{0, 1, 0, -1};
    int[] newCols = new int[]{1, 0, -1, 0};

    public static boolean isSafe(int index, int n) {
        return index >= 0 && index < n;
    }

    public static void main(String[] args) {
        new Nearest0().updateMatrix();
        System.out.println("m = " + Arrays.deepToString(m));
    }

    public void updateMatrix() {
        //write BFS in the main function only
        Queue<Cell> q = new LinkedList<>();

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (m[r][c] == 0)
                    q.add(new Cell(r, c));
                else if (m[r][c] == 1)
                    m[r][c] = Integer.MAX_VALUE;

        //3 loops
        while (!q.isEmpty()) {
            int count = q.size();
            for (int times = 0; times < count; times++) {
                Cell curr = q.poll();

                int d = m[curr.r][curr.c] + 1;

                for (Cell neighbours : getNeigbours(curr)) {
                    m[neighbours.r][neighbours.c] = d;
                    q.add(new Cell(neighbours.r, neighbours.c));
                }
            }
        }
    }

    List<Cell> getNeigbours(Cell curr) {
        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int newR = newRows[i] + curr.r,
                    newC = newCols[i] + curr.c;

            if (isSafe(newR, rows) && isSafe(newC, cols)
                    && m[newR][newC] > m[curr.r][curr.c] + 1
            )
                neighbours.add(new Cell(newR, newC));
        }

        return neighbours;
    }

    @AllArgsConstructor
    static class Cell {
        int r, c;
    }
}
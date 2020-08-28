import models.Cell;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class NumberOfPaths {

    static int c = 0;
    static int rows, cols;
    static int[][] a;
    private static int VALID = 0;

    static void BFS(Cell node) {
        Queue<Cell> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Cell currNode = q.poll();
            if (isDestination(currNode))
                NumberOfPaths.c++;
            for (Cell neighbor : getNeighbours(currNode))
                q.add(neighbor);
        }
    }

    private static ArrayList<Cell> getNeighbours(Cell node) {
        ArrayList<Cell> neighbours = new ArrayList<>();

        //right
        Cell right = new Cell(node.row, node.col + 1);
        if (isSafe(right) && a[right.row][right.col] == VALID)
            neighbours.add(right);

        //down
        Cell down = new Cell(node.row + 1, node.col);
        if (isSafe(down) && a[down.row][down.col] == VALID)
            neighbours.add(down);

        return neighbours;
    }

    private static boolean isDestination(Cell cell) {
        return cell.row == rows - 1 && cell.col == cols - 1;
    }

    private static boolean isSafe(Cell cell) {

        return cell.col >= 0 && cell.col < cols && cell.row >= 0 && cell.row < rows;
    }

    public static void main(String[] args) {
//        int[][] a=new int[3][3]{[[0,0,0],[0,1,0],[0,0,0]]};
        System.out.println(numberOfPaths(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    int numberOfPaths(int[][] a) {//O(rows*cols) space: O(rows*cols + 2*rows*cols)
        //just to keep the code clean
        rows = a.length;
        cols = a[0].length;
        NumberOfPaths.a = a;

        int start = a[0][0];
        if (start == VALID && rows == 1 && cols == 1)
            return 1;
        if (start == 1)
            return 0;

//      no need of prior buildGraph(a) function

        BFS(new Cell(0, 0));
        return NumberOfPaths.c;
    }

    int numberOfPathsDP(int[][] a) {
        int[][] numOfPaths = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (a[row - 1][col] == VALID && isSafe(row - 1))
                    numOfPaths[row][col] += numOfPaths[row - 1][col];
                //for col-1
            }
        }
    }


}

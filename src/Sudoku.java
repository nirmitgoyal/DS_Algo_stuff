public class Sudoku { //4*4

    private boolean check(int[][] a, int r, int c, int num) {
        for (int i = 0; i < 4; i++)
            if (a[r][i] == num || a[i][c] == num)
                return false;

        int x = (r / 2) * 2, y = (c / 2) * 2;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                if (a[x + i][y + j] == num)
                    return false;

        return true;
    }

    boolean solve(int[][] a, int r, int c) {
        if (c >= 4) {
            c = 0;
            r++;
        }
        if (r >= 4)
            return true; //1. complete
        //base conditions finished

        if (a[r][c] > 0)
            return solve(a, r, c + 1);

        // now we have empty cells(filled with -1)
        for (int i = 1; i <= 4; i++) { //2. check for all possibilities
            if (check(a, r, c, i)) { //3. check for validity
                a[r][c] = i;//4. do
                if (solve(a, r, c + 1)) //5. recurse
                    return true;
                a[r][c] = -1; //6. undo: if current state can affect the prev state, then backtracking/undo is necessary
            }
        }

        return false;
    }
}

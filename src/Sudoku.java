public class Sudoku { //4*4

    private boolean isValid(int[][] a, int r, int c, int num) { // can i place num @ a[r][c] ?
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

    boolean sudoku(int[][] a, int r, int c) { //call sudoku(a, 0, 0) //Assume empty cells are filled by -1
        if (c == 4) {
            c = 0;
            r++;
        }
        if (r == 4)
            return true; //1. Complete
        //base conditions finished

        if (a[r][c] > 0)
            return sudoku(a, r, c + 1);

        // now we have empty cells(filled with -1)
        for (int num = 1; num <= 4; num++)  //2. Check for all possibilities
            if (isValid(a, r, c, num)) { //3. Check for validity
                a[r][c] = num; //4. Do

                if (sudoku(a, r, c + 1)) //5. Recurse to solve
                    return true;

                a[r][c] = -1; //6. Undo: if current state can affect the prev state, then backtracking/undo is necessary
            }

        return false;
    }
}

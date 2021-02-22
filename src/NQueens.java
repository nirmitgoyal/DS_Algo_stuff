public class NQueens {

    private boolean check(int r, int[] column, int c) { //can I place queen at column = c for row = r
        for (int row = 0; row < r; row++) { //for all the rows before r
            int
                    r1 = row, //r1, c1 are existing queens
                    c1 = column[row],
                    r2 = r, //placing (r2, c2)
                    c2 = c;
            if (column[r1] == c2 || (r2 - r1 == c2 - c1) || (r1 - r2 == c2 - c1)) // last 2 ORs for the 2 diganols, can also be written as abs(r1-r2)==abs(c1-c2)
                return false;
        }

        return true;
    }

    //working
    void nQueen(int r, int[] column) { //queen is at (i, column[i])
        if (r == n)
            return; //1. Complete

        for (int c = 0; c < n; c++) //2. Check for all possibilities(all columns)
            if (check(r, column, c)) { //3. Check for validity
                column[r] = c; //4. Do

                nQueen(r + 1, column); //5. Recurse to solve
                //6. Undo not needed
            }
    }
}

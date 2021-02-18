public class NQueens {

    private boolean check(int r, int[] column, int c) { //can I place queen at column = c for row = r
        for (int row = 0; row < r; row++) {
            int r1 = row, c1 = column[row];
            int r2 = r, c2 = c;
            if (column[row] == c || (r2 - r1 == c2 - c1) || (r1 - r2 == c2 - c1)) // last 2 ORs for the 2 diganols, can also be written as abs(r1-r2)==abs(c1-c2)
                return false;
        }

        return true;
    }

    //working
    boolean nQueen(int r, int[] column) { //queen is at (i, column[i])
        if (r == n)
            return true; //1. Complete

        for (int c = 0; c < n; c++) { //2. Check for all possibilities
            if (check(r, column, c)) { //3. Check for validity
                column[r] = c; //4. Do

                if (nQueen(r + 1, column))  //5. Recurse to solve
                    return true;
                //6. Undo not needed
            }
        }

        return false;
    }
}

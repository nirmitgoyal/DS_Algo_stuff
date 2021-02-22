import java.util.Arrays;
import java.util.Collections;

public class RotateClockwise {

    void rotateClockwise(int[][] m) {
        //flip along diagonal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int temp = m[row][col];
                m[row][col] = m[col][row];
                m[col][row] = temp;
            }
        }

        //reverse all rows one-by-one
        for (int row = 0; row < rows; row++)
            Collections.reverse(Arrays.asList(m[row]));
    }
}

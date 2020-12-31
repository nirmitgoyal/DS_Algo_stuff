import java.util.Arrays;
import java.util.Collections;

public class RotateClockwise {

    void rotateClockwise(int[][] m) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int temp = m[row][col];
                m[row][col] = m[col][row];
                m[col][row] = temp;
            }
        }

        for (int row = 0; row < rows; row++)
            Collections.reverse(Arrays.asList(m[row]));
    }
}

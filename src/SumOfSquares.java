import static java.lang.Math.min;
import static utils.Utils.isSafeIndex;

public class SumOfSquares {

    int minElementsRequired(int[] list, int n) {//Assume, list always contains a 1
        int[] cache = new int[n + 1];
        for (int i = 0; i < cache.length; i++)
            cache[i] = i;

        for (int i = 0; i < cache.length; i++) {
            for (int element : list) {
                int indexToFill = i + element;
                if (isSafeIndex(indexToFill, cache.length))
                    cache[indexToFill] = min((cache[i] + 1), cache[indexToFill]);
            }
        }

        return cache[cache.length - 1];
    }
}

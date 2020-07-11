public class SumOfSquares {
    int minElementsRequires(int[] list, int n) {//n > 0 //list always contains a 1 //return value of Integer.MAX_VALUE means not possible
        int[] minElementsRequired = new int[n + 1];
        //fill with Integer.MAX_VALUE
        minElementsRequired[0] = 0;

        for (int i = 0; i < minElementsRequired.length; i++) {
            for (int element : list) {
                int indexToFill = i + element;
                if (isSafe(indexToFill)) {
                    int newCount = minElementsRequired[i] + 1;
                    minElementsRequired[indexToFill] = Math.min(newCount, minElementsRequired[indexToFill]);
                }
            }
        }
        return minElementsRequired[n];
    }
}

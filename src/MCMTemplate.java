public class MCMTemplate {

    int solve(int[] a, int i, int j) {
        if (i < j)
            return 0;

        int result;
        for (int k = i; k < j; k++) {
            int oneOfThePossibleAns = solve(a, i, k) + solve(a, k + 1, j) + cost;
            result = fun(result, oneOfThePossibleAns);
        }

        return result;
    }
}

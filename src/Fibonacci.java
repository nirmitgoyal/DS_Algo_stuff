public class Fibonacci {

    int fib(int n) {
        if (n <= 2)
            return n;

        int prevPrev = 1, prev = 2, curr;

        int i = 3;
        while (i <= n) {
            curr = prevPrev + prev;

            prevPrev = prev;
            prev = curr;

            i++;
        }

        return curr;
    }
}

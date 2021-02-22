public class Fibonacci {

    int fib(int n) {
        if (n <= 2)
            return n;

        //declare 3 values
        int
                curr = 0,
                prev = 2,
                prevPrev = 1;

        for (int i = 3; i <= n; i++) {
            curr = prevPrev + prev;

            prevPrev = prev;
            prev = curr;
        }

        return curr;
    }
}

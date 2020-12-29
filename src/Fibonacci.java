public class Fibonacci {

    int fib(int n) {
        if (n <= 2)
            return n;

        //declare 3 values
        int prevPrev = 1, prev = 2, curr = 0;

        int i = 3;
        while (i++ <= n) {
            curr = prevPrev + prev;

            prevPrev = prev;
            prev = curr;
        }

        return curr;
    }
}

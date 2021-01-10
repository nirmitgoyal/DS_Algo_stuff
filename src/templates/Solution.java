package templates;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//template from http://codeforces.com/blog/entry/7018 with my customization
//long max value:(64 b) 9*10^18  i.e. 18 to 19 digits
//int max value:(32 b) 2*10^8  i.e. 8 to 9 digits

public class Solution {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        final int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
//            double d = scanner.nextDouble();
//            String str = scanner.next();           // read input as String
//            String s = scanner.nextLine();       // read whole line as String
//            long n = scanner.nextLong();

            out.println(fun());
        }
        out.close();
    }

    private static int fun() {
        return 0;
    }

    private static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}


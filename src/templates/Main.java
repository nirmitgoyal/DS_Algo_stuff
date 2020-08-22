package templates;

import java.io.*;
import java.util.*;

//template from http://codeforces.com/blog/entry/7018 with my customization
//long max value:(64 b) 9*10^18  i.e. 18 to 19 digits
//int max value:(32 b) 2*10^8  i.e. 8 to 9 digits

public class Main {
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        final int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
//            double d = scanner.nextDouble();
//            String str = scanner.next();           // read input as String
//            String s = scanner.nextLine();       // read whole line as String
//            long n = scanner.nextLong();

            out.println(smallestSetCoveringIntervals(new int[]{999999999}, new int[]{1000000000} ));
        }
        out.close();
    }

    static long smallestSetCoveringIntervals(int[] first, int[] last) {


        Integer[][] a = new Integer[first.length][first.length];
        for (int i = 0; i < first.length; i++) {
            a[i][0] = first[i];
            a[i][1] = last[i];
        }
        Arrays.sort(a, new CustomComparator());

        long n = 0, largest = -1, secondLargest = -1;

        for (Integer[] interval : a) {
            long start = interval[0], end = interval[1];

            boolean isLargestIn = (start <= largest);
            boolean isSecondLargestIn = (start <= secondLargest);

            if (isLargestIn && isSecondLargestIn)
                continue;

            n += (isLargestIn ? 1 : 2);

            secondLargest = (isLargestIn ? largest : end - 1);
            largest = end;
        }

        return n;
    }

    public static class CustomComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] first, Integer[] last) {
            return (!first[1].equals(last[1]) ? first[1].compareTo(last[1]) : last[0].compareTo(first[0]));
        }
    }

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


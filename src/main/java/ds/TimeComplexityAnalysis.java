package ds;

import java.util.*;

public class TimeComplexityAnalysis {


    
    public static void main(String[] args) {
        // Time limits in microseconds
        long oneSecond = 1_000_000;
        long oneMinute = 60_000_000;

        String[] functions = {
                "log n", "sqrt n", "n", "n log n", "n^2", "n^3", "2^n", "n!"
        };

        System.out.printf("%-10s %-15s %-15s\n", "Function", "1 Second (n)", "1 Minute (n)");
        for (String func : functions) {
            long maxN1Sec = computeMaxN(oneSecond, func);
            long maxN1Min = computeMaxN(oneMinute, func);
            System.out.printf("%-10s %-15d %-15d\n", func, maxN1Sec, maxN1Min);
        }
    }

    public static long computeMaxN(long timeLimit, String func) {
        switch (func) {
            case "log n":
                return (long) Math.pow(2, timeLimit);
            case "sqrt n":
                return timeLimit * timeLimit;
            case "n":
                return timeLimit;
            case "n log n":
                for (long n = 1; n < Integer.MAX_VALUE; n++) {
                    if (n * log2(n) > timeLimit)
                        return n - 1;
                }
                break;
            case "n^2":
                return (long) Math.sqrt(timeLimit);
            case "n^3":
                return (long) Math.cbrt(timeLimit);
            case "2^n":
                return (long) (log2(timeLimit));
            case "n!":
                long n = 1;
                long fact = 1;
                while (fact <= timeLimit) {
                    n++;
                    fact *= n;
                    if (fact < 0) break;  // overflow protection
                }
                return n - 1;
        }
        return -1; // in case of error
    }

    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
}

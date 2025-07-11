import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        System.out.println(" result: ");
//        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeries(n));
//            if (i < n - 1) System.out.print(",");
//        }
//        System.out.println(Arrays.toString(fibonacciNumber(n)));
    }

//    public static int[] fibonacciNumber(int n) {
//        int[] dp = new int[n];
//        if (n > 0) dp[0] = 0;
//        if (n > 1) dp[1] = 1;
//        for (int i = 2; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp;
//    }

    public static int fibonacciSeries(int n) {
        if (n < 2) return n;
        return fibonacciSeries(n - 1) + fibonacciSeries(n - 2);
    }
}

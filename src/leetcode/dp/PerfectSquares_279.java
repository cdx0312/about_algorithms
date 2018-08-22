package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (int)Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares_279().numSquares(13));
    }
}

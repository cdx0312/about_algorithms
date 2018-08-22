package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/12
 * 0-1背包问题
 */
public class Knapsack01 {
    int[][] dp;
    //递归
    public int knapscak01(int[] w, int[] v, int C) {
        dp = new int[w.length][C + 1];
        return bestValue(w,v, w.length-1,C);
    }

    private int bestValue(int[] weight, int[] value, int index, int capacity) {
        if (index < 0 || capacity <= 0)
            return 0;
        int res = bestValue(weight, value, index - 1, capacity);
        if (capacity > weight[index])
            res = Math.max(value[index] + bestValue(weight, value, index - 1, capacity - weight[index]), res);
        return res;
    }

    //dp O(N*C) O(N*C)
    public int knapscak01_2(int[] w, int[] v, int C) {
        int n = w.length;
        if (n == 0)
            return 0;
        int[][] dp = new int[n][C + 1];
        for (int j = 0; j <= C; j++)
            dp[0][j] = (j >= w[0] ? v[0] : 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= w[i])
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
            }
        }
        return dp[n-1][C];
    }

    //dp O(C) O(N*C)
    public int knapscak01_3(int[] w, int[] v, int C) {
        int n = w.length;
        if (n == 0)
            return 0;
        int[][] dp = new int[2][C + 1];
        for (int j = 0; j <= C; j++)
            dp[0][j] = (j >= w[0] ? v[0] : 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i%2][j] = dp[(i-1)%2][j];
                if (j >= w[i])
                    dp[i%2][j] = Math.max(dp[i%2][j], v[i] + dp[(i-1)%2][j-w[i]]);
            }
        }
        return dp[(n-1)%2][C];
    }

    //dp O(C) O(N*C)
    public int knapscak01_4(int[] w, int[] v, int C) {
        int n = w.length;
        if (n == 0)
            return 0;
        int[] dp = new int[C + 1];
        for (int j = 0; j <= C; j++)
            dp[j] = (j >= w[j] ? v[0] : 0);
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j-w[i]]);
            }
        }
        return dp[C];
    }
}

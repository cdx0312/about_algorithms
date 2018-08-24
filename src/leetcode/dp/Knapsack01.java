package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/12
 * 0-1背包问题:有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
 基本思路 ：
 这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。 用子问题定义状态：即f[i][v]表示前i件物品恰放入一个容量为v的背包
 可以获得的最大价值。则其状态转移方程便是：
 tab[i][j] = max(tab[i-1][j-weight[i]]+value[i],tab[i-1][j]) ({i,j|0<i<=n,0<=j<=total})
 *
 */
public class Knapsack01 {
    private static int[][] dp;

    public static void main(String[] args) {
        int[] weight = new int[]{5,4,7,2,6};
        int[] value = new int[]{12,3,10,2,6};
        int  cap= 10;
        System.out.println(knapscak01_4(weight, value, cap));
    }

    //递归
    private static int knapscak01(int[] w, int[] v, int C) {
        return bestValue(w,v, w.length-1,C);
    }

    private static int bestValue(int[] weight, int[] value, int index, int capacity) {
        if (index < 0 || capacity <= 0)
            return 0;
        int res = bestValue(weight, value, index - 1, capacity);
        if (capacity > weight[index])
            res = Math.max(value[index] + bestValue(weight, value, index - 1, capacity - weight[index]), res);
        return res;
    }

    //dp O(N*C) O(N*C)
    public static int knapscak01_2(int[] w, int[] v, int C) {
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
    public static int knapscak01_3(int[] w, int[] v, int C) {
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
    public static int knapscak01_4(int[] w, int[] v, int C) {
        int n = w.length;
        if (n == 0)
            return 0;
        int[] dp = new int[C + 1];
        for (int j = 0; j <= C; j++)
            dp[j] = (j >= w[0] ? v[0] : 0);
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j-w[i]]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[C];
    }
}

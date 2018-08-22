package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp =new int[m+1][n+1];
        dp[1][1] = grid[0][0];
        for (int i = 0; i <= m; i++)
            dp[i][0] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    continue;
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        for (int i = 0; i <= m; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        new MinimumPathSum_64().minPathSum(grid);
    }
}

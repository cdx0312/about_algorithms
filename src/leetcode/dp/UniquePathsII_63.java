package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class UniquePathsII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 0;
        for (int j = 0; j < n; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                if (obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
            }
        }
//        for (int i = 0; i <= m; i++)
//            System.out.println(Arrays.toString(dp[i]));
        return dp[m][n];
    }
}

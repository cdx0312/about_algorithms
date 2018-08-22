package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class ClimbingStairs_70 {
    //dp
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i-1] + res[i - 2];
        }
        return res[n];
    }

    //递归
    public int climbStairs1(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }
}

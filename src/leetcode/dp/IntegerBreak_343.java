package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class IntegerBreak_343 {
    int[] result;
    public int integerBreak(int n) {
        result = new int[n+1];
        return breakInteger(n);
    }
    //递归
    private int breakInteger(int n) {
        if (n == 1)
            return 1;
        if (result[n] != 0)
            return result[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(i*(n-i), Math.max(i * breakInteger(n-i), res));
            result[n] = res;
        }
        return res;
    }

    //动态规划
    public int integerBreak1(int n) {
        //数字i的最大乘积
        int[] record = new int[n+1];
        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                record[i] = Math.max(record[i], Math.max(j * (i-j), j * record[i-j]));
            }
        }
        return record[n];
    }
}

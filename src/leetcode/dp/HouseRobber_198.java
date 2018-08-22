package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class HouseRobber_198 {
    //dp[i]表示考虑抢劫nums[i...n]所获得的最大收益
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return tryRob(nums, 0);
    }

    //考虑抢劫nums[index..nums.length]这个范围内的所有房子
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res,nums[i] + tryRob(nums, i + 2));
        }
        dp[index] = res;
        return res;
    }

    //dp方法
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dps = new int[n];
        for (int i = 0; i < n; i++)
            dps[i] = -1;
        dps[n-1] = nums[n-1];
        for (int i = n -2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dps[i] = Math.max(dps[i], nums[j] + (j+2 < n ? dps [j+2] : 0));
            }
        }
        return dps[0];
    }
}

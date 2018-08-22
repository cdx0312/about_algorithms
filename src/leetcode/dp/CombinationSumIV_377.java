package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/12
 */
public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += combinationSum4(nums, target - nums[i]);
        }
        return res;
    }

    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <nums.length; j++) {
                if (i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}

package leetcode.dp;

import java.util.Arrays;

/**
 * Created by cdx0312
 * 2018/4/12
 * 最长上升子序列问题
 */
public class LongestIncreasingSubsequence_300 {
    //O(N^2)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};
        System.out.println(new LongestIncreasingSubsequence_300().lengthOfLIS(arr));

    }
}

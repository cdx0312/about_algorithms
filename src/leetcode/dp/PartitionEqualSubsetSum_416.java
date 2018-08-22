package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/12
 */
public class PartitionEqualSubsetSum_416 {
    //dp[i][j]表示索引为0.。i的元素能否填充一个容量为j的背包
    //-1表示未计算，0表示不可以，1表示可以
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = sumArr(nums);
        dp = new int[nums.length][sum/2+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }
        if (sum % 2 != 0)
            return false;
        return trPartition(nums, nums.length - 1, sum / 2);
    }
    //nums[0..index]中能否填充sum,,递归
    private boolean trPartition(int[] nums, int index, int sum) {
        if (sum == 0)
            return true;
        if (sum < 0 || index < 0)
            return false;
        if (dp[index][sum] != -1)
            return dp[index][sum] == 1;
        dp[index][sum] = (trPartition(nums, index-1, sum) || trPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return dp[index][sum] == 1;
    }

    private int sumArr(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        return sum;
    }
    //DP
    public boolean canPartition1(int[] nums) {
        int sum = sumArr(nums);
        if (sum % 2 != 0)
            return false;

        int n = nums.length;
        int capacity = sum / 2;
        boolean[] dps = new boolean[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dps[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = capacity; j >= nums[i]; j--) {
                dps[j] = dps[j] || dps[j-nums[i]];
            }
        }
        return dps[capacity];
    }
}

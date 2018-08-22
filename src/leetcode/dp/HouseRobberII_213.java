package leetcode.dp;

/**
 * Created by cdx0312
 * 2018/4/11
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[i];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}

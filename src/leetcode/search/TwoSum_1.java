package leetcode.search;

import java.util.HashMap;

/**
 * Created by cdx0312
 * 2018/4/4
 */
public class TwoSum_1 {
    //1、暴力O(N^2)
    public int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //O(N) O(N)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                res[1] = i;
                res[0] = record.get(complement);
                return res;
            }
            record.put(nums[i], i);
        }
        return res;
    }

}

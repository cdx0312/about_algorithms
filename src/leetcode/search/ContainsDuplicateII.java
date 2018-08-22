package leetcode.search;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by cdx0312
 * 2018/4/6
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i]))
                return true;
            record.add(nums[i]);
            if (record.size() == k + 1)
                record.remove(nums[i-k]);
        }
        return false;
    }
}

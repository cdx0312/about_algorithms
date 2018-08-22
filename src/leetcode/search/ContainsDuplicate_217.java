package leetcode.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cdx0312
 * 2018/4/6
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i]))
                return true;
            record.add(nums[i]);
        }
        return false;
    }
}

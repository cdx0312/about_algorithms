package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class Permutations_46 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(list, nums,0, used);
        return res;
    }

    private void dfs(List<Integer> list, int[] nums, int pos, boolean[] used) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(list, nums, pos + 1, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

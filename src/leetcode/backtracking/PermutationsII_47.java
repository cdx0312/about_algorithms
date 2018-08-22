package leetcode.backtracking;

import sun.misc.Perf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class PermutationsII_47 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, nums, used);
        return res;
    }

    private void dfs(List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(list, nums, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        PermutationsII_47 p = new PermutationsII_47();
        p.permuteUnique(nums);
        System.out.println(p.res);
    }
}

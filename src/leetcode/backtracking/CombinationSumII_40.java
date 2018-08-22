package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class CombinationSumII_40 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void combinationSum(int[] candidates, int target, ArrayList<Integer> list, int pos) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (i != pos && candidates[i] == candidates[i-1])
                continue;
            if (target < candidates[i]) {
                return;
            } else {
                list.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], list, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}

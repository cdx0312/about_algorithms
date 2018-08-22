package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class CombinationSum_39 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target < candidates[i]) {
                return;
            } else {
                list.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}

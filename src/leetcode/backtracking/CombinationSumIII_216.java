package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class CombinationSumIII_216 {
    List<List<Integer>> res = new ArrayList<>();
    public static final int[] nums = {1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0)
            return res;
        combinationSum3(k, n, 0, new ArrayList<Integer>());
        return res;
    }

    private void combinationSum3(int k, int sum, int index, ArrayList<Integer> list) {
         if (k == 0 && sum == 0){
             res.add(new ArrayList<>(list));
             return;
         }

         for (int i = index; i < nums.length; i++) {
             if (sum < nums[index])
                 return;
             list.add(nums[i]);
             combinationSum3(k-1, sum- nums[i], i + 1, list);
             list.remove(list.size() - 1);
         }
    }
}

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class SubSets_78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        subsets(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void subsets(int[] nums, int index, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets_78 s = new SubSets_78();
        int[] num = {1,2,3};
        s.subsets(num);
        System.out.println(s.res);
    }
}

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class SubSetsII_90 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void subsets(int[] nums, int index, ArrayList<Integer> list) {
        if (nums.length == index) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        subsets(nums, index + 1,list);
        list.remove(list.size() - 1);
        while (index + 1 < nums.length && nums[index + 1] == nums[index])
            index++;
        subsets(nums, index + 1, list);
    }

//    private void subsets(int[] nums, int index, ArrayList<Integer> list) {
//        if (!res.contains(list))
//            res.add(new ArrayList<>(list));
//        for (int i = index; i < nums.length; i++) {
//            list.add(nums[i]);
//            subsets(nums, i + 1, list);
//            list.remove(list.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        SubSetsII_90 s = new SubSetsII_90();
        int[] num = {4,4,4,1,4};
        s.subsetsWithDup(num);
        System.out.println(s.res);
    }
}

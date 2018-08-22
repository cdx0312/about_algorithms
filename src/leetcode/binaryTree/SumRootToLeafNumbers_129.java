package leetcode.binaryTree;

import leetcode.linkedList.ListNode;
import leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPathSum(root, res, list);
        int result = 0;
        for (List<Integer> list1 : res) {
            int tmp = 0;
            for (Integer i : list1) {
                tmp = tmp * 10 + i;
            }
            result += tmp;
        }
        return result;
    }


    private void getPathSum(TreeNode root,List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        } else {
            getPathSum(root.left, res, list);
            getPathSum(root.right, res, list);
        }
        list.remove(list.size() - 1);
    }

    public int sumNumbers1(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}

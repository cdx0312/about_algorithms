package leetcode.binaryTree;

import leetcode.linkedList.ListNode;
import leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPathSum(root, sum, res,list);
        return res;
    }

    /**
     *
     * @param root 跟节点
     * @param sum 和
     * @param res 返回的二维数组
     * @param list 单个路径
     */
    private void getPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        //递归到叶子节点进行判断，决定是否将当前list添加到列表中，不是叶子节点则继续递归左子树和右子树。
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        } else {
            getPathSum(root.left, sum - root.val, res, list);
            getPathSum(root.right, sum - root.val, res, list);
        }
        //添加完记得删除，回溯上一个状态。
        list.remove(list.size() - 1);
    }
}

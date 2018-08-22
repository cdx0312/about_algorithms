package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right ,sum);
        return res;
    }

    private int findPath(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.val == sum)
            res++;
        return res + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
    }
}

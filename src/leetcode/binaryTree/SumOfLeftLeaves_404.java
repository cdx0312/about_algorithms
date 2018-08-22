package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

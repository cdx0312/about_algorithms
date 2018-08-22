package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val == right.val)
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right,right.left);
        return false;
    }
}

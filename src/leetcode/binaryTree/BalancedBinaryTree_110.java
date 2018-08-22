package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(right - left) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

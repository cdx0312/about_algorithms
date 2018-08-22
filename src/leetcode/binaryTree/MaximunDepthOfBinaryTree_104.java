package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class MaximunDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}

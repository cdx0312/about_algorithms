package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class InverseBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}

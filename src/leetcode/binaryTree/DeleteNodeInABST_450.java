package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class DeleteNodeInABST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }
            TreeNode min = find(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode find(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}

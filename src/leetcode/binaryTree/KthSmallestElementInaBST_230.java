package leetcode.binaryTree;

import leetcode.stack.TreeNode;

import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class KthSmallestElementInaBST_230 {
    //堆栈方法
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack .push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0)
                return node.val;
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

    //递归方法
    public int kthSmallest1(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count)
            return kthSmallest(root.left, k);
        else if (k > count + 1)
            return kthSmallest(root.right, k - 1 -count);
        return root.val;
    }

    private int countNodes(TreeNode left) {
        if (left == null)
            return 0;
        return 1 + countNodes(left.left) + countNodes(left.right);
    }
}

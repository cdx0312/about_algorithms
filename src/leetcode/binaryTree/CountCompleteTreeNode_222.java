package leetcode.binaryTree;

import leetcode.stack.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class CountCompleteTreeNode_222 {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        int nodes = 0;
        while (root != null) {
            if (getHeight(root.right) == h - 1){
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + getHeight(root.left);
    }
    //队列
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.val != -1) {
                tmp.val = -1;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    count++;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    count++;
                }
            }
        }
        return count;
    }
}

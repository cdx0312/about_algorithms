package leetcode.binaryTree;

import leetcode.linkedList.ListNode;
import leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/9
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        for (String aLeft : left) {
            res.add(String.valueOf(root.val) + "->" + aLeft);
        }

        List<String> right = binaryTreePaths(root.right);
        for (String aRight : right) {
            res.add(String.valueOf(root.val) + "->" + aRight);
        }
        return res;
    }
}

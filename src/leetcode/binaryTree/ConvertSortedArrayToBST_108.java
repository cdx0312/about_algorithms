package leetcode.binaryTree;

import leetcode.stack.TreeNode;

/**
 * Created by cdx0312
 * 2018/4/10
 */
public class ConvertSortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return help(nums, 0, nums.length-1);
    }

    private TreeNode help(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, low, mid - 1);
        root.right = help(nums, mid + 1, high);
        return root;
    }
}

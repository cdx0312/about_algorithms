package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class BinaryTreePrecoderTraversal_144 {
    List<Integer> res = new ArrayList<>();

    //递归方法
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }
    //非递归方法
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }

    // Command
    public List<Integer> preorderTraversal11(TreeNode root) {
        if (root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (stack.isEmpty()) {
            Command command = stack.pop();
            if (command.command.equals("print")) {
                res.add(command.node.val);
            } else {
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    class Command {
        String command;
        TreeNode node;

        public Command(String command, TreeNode node) {
            this.command = command;
            this.node = node;
        }
    }

}

package leetcode.stack;

import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class BinaryTreeInOrderTraversal_94 {
    List<Integer> res = new ArrayList<>();

    //递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }
    //非递归方法
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                stack.push(new Command("print", command.node));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return res;
    }

    class Command{
        String s;  //print,go
        TreeNode node;
        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
}

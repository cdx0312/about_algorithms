package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class BinaryTreePostorderTraversal_145 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                stack.push(new Command("print", command.node));
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return res;
    }

    class Command {
        String s;//print, go
        TreeNode node;
        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
}

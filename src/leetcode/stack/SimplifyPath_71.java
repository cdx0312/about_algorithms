package leetcode.stack;

import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (String s : strings) {
            switch (s) {
                case "." :
                    break;
                case "..":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    if (!s.equals(""))
                        stack.push(s);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()) {
            sb.insert(0,  "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath_71 simplifyPath_71 = new SimplifyPath_71();
        String s = "/...";
        System.out.println(simplifyPath_71.simplifyPath(s));
    }
}

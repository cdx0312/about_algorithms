package leetcode.stack;

import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch =='{' || ch == '[')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                char cha = stack.pop();
                char match;
                switch (ch) {
                    case '(' :
                        match = ')';
                        break;
                    case '[':
                        match=']';
                        break;
                    default:
                        match='}';
                        break;
                }
                if (cha != match)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

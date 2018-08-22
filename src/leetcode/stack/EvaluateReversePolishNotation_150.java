package leetcode.stack;

import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "*":
                    number.push(number.pop() * number.pop());
                    break;
                case "+":
                    number.push(number.pop() + number.pop());
                    break;
                case "-":
                    number.push(-(number.pop() - number.pop()));
                    break;
                case "/":
                    int tmp1 = number.pop();
                    int tmp2 = number.pop();
                    number.push(tmp2 / tmp1);
                    break;
                default:
                    number.push(Integer.valueOf(s));
                    break;
            }
        }
        return number.pop();
    }
}

package leetcode.linkedList;

import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class AddTwoNumbersII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        int c = 0;
        ListNode result = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty() || c == 1) {
            int tmp = 0;
            if (stack1.isEmpty() && stack2.isEmpty())
                tmp = c;
            else if (stack1.isEmpty())
                tmp = c + stack2.pop();
            else if (stack2.isEmpty())
                tmp = c + stack1.pop();
            else
                tmp = stack1.pop() + stack2.pop() + c;
            ListNode node = new ListNode(tmp % 10);
            c = tmp / 10;
            node.next = result.next;
            result.next = node;
        }
        return result.next;
    }
}

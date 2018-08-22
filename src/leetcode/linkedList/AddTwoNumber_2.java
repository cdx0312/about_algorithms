package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class AddTwoNumber_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        ListNode result = new ListNode(0);
        ListNode cur;
        int c = 0;
        cur = result;
        while (h1 != null || h2 != null || c == 1) {
            int tmp;
            if (h1 == null && h2 == null) {
                tmp = c;
            } else if (h1 == null) {
                tmp = c + h2.val;
            } else if (h2 == null) {
                tmp = c + h1.val;
            } else {
                tmp = c + h1.val + h2.val;
            }
            cur.next = new ListNode(tmp % 10);
            c = tmp / 10;
            cur = cur.next;
            if (h1 != null)
                h1 = h1.next;
            if (h2 != null)
                h2 = h2.next;
        }
        return result.next;
    }
}

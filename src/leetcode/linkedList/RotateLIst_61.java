package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RotateLIst_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy, br = dummy;
        int length = 0;
        while (right.next != null) {
            length++;
            right = right.next;
        }

        for (int j = length - k%length; j> 0; j--)
            left = left.next;

        right.next = dummy.next;
        dummy.next = left.next;
        left.next = null;
        return dummy.next;
    }
}

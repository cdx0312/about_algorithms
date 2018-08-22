package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RecordList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        fast = slow.next;
        ListNode node = head;
        while (node != slow) {
            slow.next = fast.next;
            fast.next = node.next;
            node.next = fast;
            node = fast.next;
            fast = slow.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}

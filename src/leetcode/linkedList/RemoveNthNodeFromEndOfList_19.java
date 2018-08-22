package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r =dummy;
        for (int i = 0; i < n + 1; i++) {
            r = r.next;
        }
        while (r != null) {
            l = l. next;
            r = r.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}

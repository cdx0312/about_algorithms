package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        ListNode prev = null, left, right;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        left = sortList(head);
        right = sortList(slow);
        return mergeTwoList(left, right);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null)
            prev.next = l1;
        if (l2 != null)
            prev.next = l2;
        return dummy.next;
    }
}

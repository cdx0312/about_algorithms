package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val)
                pre.next = cur.next;
            else {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

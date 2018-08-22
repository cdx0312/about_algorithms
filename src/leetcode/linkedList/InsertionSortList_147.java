package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                while (pre.next.val < cur.next.val)
                    pre = pre.next;
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = dummy;
            }  else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

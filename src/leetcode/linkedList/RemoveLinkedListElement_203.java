package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RemoveLinkedListElement_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

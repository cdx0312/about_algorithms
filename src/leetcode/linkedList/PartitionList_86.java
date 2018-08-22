package leetcode.linkedList;

import java.util.List;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode smaller = new ListNode(0);
        ListNode bigger = new ListNode(0);
        ListNode lastSmall = smaller;
        ListNode lastbig = bigger;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x){
                lastSmall.next = cur;
                lastSmall = lastSmall.next;
            }
            if (cur.val >= x) {
                lastbig.next = cur;
                lastbig = lastbig.next;
            }
            cur = cur.next;
        }
        lastbig.next = null;
        lastSmall.next = bigger.next;
        return smaller.next;
    }
}

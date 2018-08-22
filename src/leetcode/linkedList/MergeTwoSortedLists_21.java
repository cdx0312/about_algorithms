package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode curr = dummy;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                curr.next = node2;
                break;
            } else if (node2 == null) {
                curr.next = node1;
                break;
            } else {
                if (node1.val <= node2.val) {
                    curr.next = node1;
                    node1 = node1.next;
                } else {
                    curr.next = node2;
                    node2 = node2.next;
                }
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

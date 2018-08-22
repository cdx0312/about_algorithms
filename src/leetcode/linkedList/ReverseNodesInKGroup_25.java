package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        dummy.next = head;
        while (true) {
            ListNode node = start, cur, n = node;
            start = node.next;
            for (int i = 0; i < k && n != null; i++)
                n = n.next;
            if (n == null)
                break;
            for (int i = 0; i < k - 1; i++) {
                cur = node.next;
                node.next = cur.next;
                cur.next = n.next;
                n.next = cur;
            }
        }
        return dummy.next;
    }
}

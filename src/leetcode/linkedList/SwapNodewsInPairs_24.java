package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class SwapNodewsInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node1, node2, next;
        while (pre.next != null && pre.next.next != null) {
            node1 = pre.next;
            node2 = node1.next;
            next = node2.next;
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            //靠后的一对节点
            pre = node1;
        }
        return dummy.next;
    }
}

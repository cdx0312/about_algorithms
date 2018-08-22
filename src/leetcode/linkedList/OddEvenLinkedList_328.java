package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode lastOdd = odd;
        ListNode lastEven = even;
        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            if (i % 2 == 0) {
                lastEven.next = cur;
                lastEven = lastEven.next;
            } else {
                lastOdd.next = cur;
                lastOdd = lastOdd.next;
            }
            cur = cur.next;
            i++;
        }
        lastEven.next = null;
        lastOdd.next = even.next;
        return odd.next;
    }
}

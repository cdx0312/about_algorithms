package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        fast = slow.next;
        ListNode node = head;
        while (fast != null) {
            if (node.val != fast.val)
                return false;
            node = node.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}

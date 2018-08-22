package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class ReverseLinkedList_206 {
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 创建一个链表
     * @param arr
     * @param n
     * @return
     */
    private static ListNode createLinkedList(int arr[], int n) {
        if (n == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        ListNode head = createLinkedList(arr, n);
        printLinkedList(head);
        head = new ReverseLinkedList_206().reverseList(head);
        printLinkedList(head);
    }

}

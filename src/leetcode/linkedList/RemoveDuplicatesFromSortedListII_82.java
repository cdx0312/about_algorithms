package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        boolean repeat = false;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                repeat = true;
                cur = cur.next;
            } else {
                cur = cur.next;
                if(!repeat){
                    pre = pre.next;
                }
                pre.next = cur;
                repeat = false;
            }
        }

        if(repeat) pre.next = null;
        return dummy.next;
    }
}

package leetcode.linkedList;

/**
 * Created by cdx0312
 * 2018/4/7
 */
public class DeleteNodeInALinkedList_237 {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

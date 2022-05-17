package problemSet_1;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
public class RemoveDuplicatesFromSortedListii {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode parentNode = null, node = head; head = null;

        while(node != null) {

            node = getNonDuplicateNode(node);

            if (head == null) head = node;
            if (parentNode != null) parentNode.next = node;
            parentNode = node;
            node = node == null ? node :node.next;
        }

        return head;

    }

    ListNode getNonDuplicateNode(ListNode node) {
        if (! (node != null && node.next != null && node.val == node.next.val )) return node;
        //if (node == null || node.next = null || node.val != node.next.val) return node;
        while(node.next!= null && node.next.val == node.val)
            node = node.next;
        node = node.next;
        return getNonDuplicateNode(node);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

package problemSet_1;

// https://leetcode.com/problems/partition-list/submissions/
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode node = head;

        ListNode smallHead = null, smallParent = null;
        ListNode largeHead = null, largeParent = null;

        while(node != null) {
            if (node.val < x) {
                if (smallHead == null) smallHead = node;
                if (smallParent != null) smallParent.next = node;
                smallParent = node;
            } else {
                if (largeHead == null) largeHead = node;
                if (largeParent != null) largeParent.next = node;
                largeParent = node;
            }

            node = node.next;

        }
        if (largeParent != null) largeParent.next = null;
        if (smallParent != null) {
            smallParent.next = largeHead;
            return smallHead;
        }
        return largeHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

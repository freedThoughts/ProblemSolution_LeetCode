/*
package problemSet_1;

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *//*


// https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = node;
        node.next = swap(node.next);
        return temp;
    }
}
*/

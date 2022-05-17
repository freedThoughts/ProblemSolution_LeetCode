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

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int number = nextNodeNumberFromEnd(head, n);
        if (number == n) {
            return head.next;
        }
        return head;
    }

    private int nextNodeNumberFromEnd(ListNode node, int n) {
        if(node == null) {
            return 0;
        }

        int nodeNumber = nextNodeNumberFromEnd(node.next, n);
        if (n == nodeNumber) {
            node.next = node.next.next;
        }
        return nodeNumber+1;
    }
}
*/

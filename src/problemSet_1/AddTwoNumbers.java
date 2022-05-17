package problemSet_1;


//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int balance) {
        if (l1 == null && l2 == null && balance == 0) {
            return null;
        }

        if (l1 == null && l2 == null && balance != 0) {
            return new ListNode(balance%10, addTwoNumbers(l1, l2, balance/10));
        }
        if(l1 != null && l2 == null) {
            int value = l1.val + balance;
            return new ListNode(value%10, addTwoNumbers(l1.next, l2, value/10));
        }

        if(l1 == null && l2 != null) {
            int value = l2.val + balance;
            return new ListNode(value%10, addTwoNumbers(l1, l2.next, value/10));
        }

        int value = l2.val + l1.val + balance;
        return new ListNode(value%10, addTwoNumbers(l1.next, l2.next, value/10));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

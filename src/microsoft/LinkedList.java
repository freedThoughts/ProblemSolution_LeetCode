package microsoft;

public class LinkedList {

    Node makeLinkList(Node head) {
        //
        if (head == null) return head;
        Node midNode = getMidNode(head);

        // midNode = c

        Node head2 = reverse(midNode, null);

        // a b  e d c
        mergeNodes(head, head2);
        return head;

    }

    void mergeNodes(Node head1, Node head2){
        Node result = null;

        while(head2 != null) {
            if (result == null) {
                result = head1;
                head1 = head1.next;
            } else {
                result.next = head1;
                result = result.next;
            }

            result.next = head2;
            head2 = head2.next;
            result = result.next;


        }
    }





    // c -> d -> e
    // next  = d
    // c -> null
    //
    // node d, c
    // next = e
    // d -> c
    //
    // node = e, prev = d
    // next = null
    // e -> d
    //
    // node = null, prev e
    // return e
    Node reverse(Node node, Node prev){
        if (node == null) return prev;
        Node next = node.next();
        node.next = prev;
        return reverse(next, node);
    }

    Node getMidNode(Node node) {
        Node fastNode = node;
        Node slowNode  = node;

        while(fastNode.next != null) {
            fastNode = fastNode.next();
            slowNode = slowNode.next();
            if (fastNode.next != null)
                fastNode = fastNode.next();
        }
        return slowNode;
    }

    class Node {
        int data;
        Node next;
        Node next() {
            return this.next;
        }
    }
}

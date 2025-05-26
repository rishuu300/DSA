/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;

        while (true) {
            if (curr.data <= data && data <= curr.next.data) {
                break;
            }

            if (curr.data > curr.next.data) {
                if (data >= curr.data || data <= curr.next.data) {
                    break;
                }
            }

            curr = curr.next;

            if (curr == head) break;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return (data < head.data) ? newNode : head;
    }
}
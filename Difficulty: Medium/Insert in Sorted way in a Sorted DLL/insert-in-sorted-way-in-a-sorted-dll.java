//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        Node temp = new Node(x);
        if(head==null)
           return temp;
           
        if(temp.data<=head.data){
            temp.next = head;
            head.prev = temp;
            return temp;
        }
        
        Node curr = head;
        while(curr.next!=null && curr.next.data<x){
            curr = curr.next;
        }
        
        if(curr.next==null){
            curr.next = temp;
            temp.prev = curr;
            return head;
        }
        
        temp.next = curr.next;
        curr.next = temp;
        temp.prev = curr;
        temp.next.prev = temp;
        return head;
    }
}
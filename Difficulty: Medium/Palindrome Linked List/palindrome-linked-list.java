//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(slow != null && fast != null){
            if(slow.data != fast.data){
                return false;
            }
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
}
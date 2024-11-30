//{ Driver Code Starts
import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    // Function to insert a node at the end of the Doubly Linked List
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    // Function to print nodes in a given doubly linked list forward
    public static void printListForward(DLLNode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to print nodes in a given doubly linked list backward
    public static void printListBackward(DLLNode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Traverse to the end of the list
        DLLNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Traverse backward from the end
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println();
    }

    // Main driver function
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            head = obj.sortDoubly(head);

            // System.out.println("Forward print:");
            printListForward(head);

            // System.out.println("Backward print:");
            printListBackward(head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    DLLNode findMid(DLLNode head){
        DLLNode slow = head;
        DLLNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    DLLNode merge(DLLNode left, DLLNode right){
        if(left == null) return right;
        if(right == null) return left;
        
        DLLNode ans = new DLLNode(0);
        DLLNode temp = ans;
        
        while(left != null && right != null){
            if(left.data <= right.data){
                temp.next = left;
                left.prev = temp;
                temp = left;
                left = left.next;
            }
            else{
                temp.next = right;
                right.prev = temp;
                temp = right;
                right = right.next;
            }
        }
        
        while(left != null){
            temp.next = left;
            left.prev = temp;
            temp = left;
            left = left.next;
        }
        
        while(right != null){
            temp.next = right;
            right.prev = temp;
            temp = right;
            right = right.next;
        }
        
        ans = ans.next;
        ans.prev = null;
        
        return ans;
    }
    
    public DLLNode sortDoubly(DLLNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        DLLNode mid = findMid(head);
        DLLNode left = head;
        DLLNode right = mid.next;
        
        mid.next = null;
        right.prev = null;
        
        left = sortDoubly(left);
        right = sortDoubly(right);
        
        return merge(left, right);
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }
            Node root = new Node(v[0]);
            int cnt = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node cur = null;
            for (int i = 1; i < n; i++) {
                Node node = new Node(v[i]);
                if (cnt == 0) {
                    cur = q.peek();
                    q.poll();
                }
                if (cnt == 0) {
                    cnt++;
                    cur.left = node;

                } else {
                    cnt = 0;
                    cur.right = node;
                }
                if (v[i] >= 0) {
                    q.add(node);
                }
            }

            Solution obj = new Solution();
            int ans = obj.countNodes(root);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int countNodes(Node root) {
        if(root==null){
           return 0;
        }
        
        int lh = 0, rh = 0;
        
        Node curr = root;
        while(curr!=null){
            curr = curr.left;
            lh++;
        }
        
        curr = root;
        while(curr!=null){
            curr = curr.right;
            rh++;
        }
        
        if(lh==rh){
           return (int)Math.pow(2,lh)-1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
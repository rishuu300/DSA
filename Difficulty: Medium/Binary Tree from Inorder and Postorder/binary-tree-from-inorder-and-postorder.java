//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InorderPostorderToTree ip = new InorderPostorderToTree();

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int[] inorder = new int[n];
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) {
                postorder[i] = Integer.parseInt(a2[i]);
            }

            Solution g = new Solution();
            Node root = g.buildTree(inorder, postorder);
            ip.preOrder(root);
            System.out.println();
            System.out.println("~");

            t--; // Decrement the test case count
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    Node buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, new int[]{inorder.length-1});
    }
    
    Node build(int in[], int post[], int st, int end, int postIndex[]){
        if(st>end){
            return null;
        }
        
        Node root = new Node(post[postIndex[0]--]);
        
        int index = -1;
        for(int i=st; i<=end; i++){
            if(in[i]==root.data){
                index = i;
                break;
            }
        }
        
        root.right = build(in,post,index+1,end,postIndex);
        root.left = build(in,post,st,index-1,postIndex);
        
        return root;
    }
}
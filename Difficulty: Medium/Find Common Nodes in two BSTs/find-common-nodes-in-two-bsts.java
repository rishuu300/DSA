//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static void inorder(Node root, TreeSet<Integer> set, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        
        inorder(root.left, set, result);
        
        if(set.contains(root.data)){
            result.add(root.data);
        }
        else{
            set.add(root.data);
        }
        
        inorder(root.right, set, result);
    }
    
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        inorder(r1, set, result);
        inorder(r2, set, result);
        
        return result;
    }
}



//{ Driver Code Starts.
class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1, root2);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
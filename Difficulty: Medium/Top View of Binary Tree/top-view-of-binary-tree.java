//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair{
    Node node;
    int hd;
    Pair(Node n, int hd){
        this.node = n;
        this.hd = hd;
    }
}

class Solution {
    static void DFS(Node root, int hd, int[] mn,
                    HashMap<Integer, Integer> map) {
        if (root == null) return;
        
        if (!map.containsKey(hd)){
            map.put(hd, root.data);
        }
        
        mn[0] = Math.min(mn[0], hd);
        
        DFS(root.left, hd - 1, mn, map);
        DFS(root.right, hd + 1, mn, map);
    }
    
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            
            if(!map.containsKey(hd)){
                map.put(hd,curr.data);
            }
            
            if(curr.left!=null)q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)q.add(new Pair(curr.right,hd+1));
        }
        
        for(int i : map.values())
            res.add(i);
        
        return res;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
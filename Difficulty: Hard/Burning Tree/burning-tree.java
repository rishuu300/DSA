//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

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
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    
    public static Node mapping(Node root, int target, HashMap<Node, Node> nodeToParent){
        Queue<Node> q = new LinkedList<>();
        Node res = null;
        
        nodeToParent.put(root, null);
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(node.data == target){
                res = node;
            }
            
            if(node.left != null){
                q.add(node.left);
                nodeToParent.put(node.left, node);
            }
            
            if(node.right != null){
                q.add(node.right);
                nodeToParent.put(node.right, node);
            }
        }
        
        return res;
    }
    
    public static int burnTime(HashMap<Node,Node> nodeToParent, Node target){
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        int Time = 0;
        
        q.add(target);
        visited.add(target);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            
            for(int i=0; i<size; i++){
                Node node = q.poll();
                
                if(node.left != null && !visited.contains(node.left)){
                    flag = true;
                    q.add(node.left);
                    visited.add(node.left);
                }
                
                if(node.right != null && !visited.contains(node.right)){
                    flag = true;
                    q.add(node.right);
                    visited.add(node.right);
                }
                
                if(nodeToParent.get(node) != null && !visited.contains(nodeToParent.get(node))){
                    flag = true;
                    q.add(nodeToParent.get(node));
                    visited.add(nodeToParent.get(node));
                }
            }
            
            if(flag){
                Time++;
            }
        }
        
        return Time;
    }
    
    public static int minTime(Node root, int target) {
        HashMap<Node,Node> nodeToParent = new HashMap<>();
        Node targetNode = mapping(root, target, nodeToParent);
        return burnTime(nodeToParent, targetNode);
        
    }
}
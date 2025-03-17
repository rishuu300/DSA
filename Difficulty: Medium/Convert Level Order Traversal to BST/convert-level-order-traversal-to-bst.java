//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        
System.out.println("~");
}
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java

class Pair {
    Node node;
    int min;
    int max;
    
    Pair(Node node, int min, int max){
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

class GFG {
    public Node constructBST(int[] arr) {
        Queue<Pair> q = new LinkedList<>();
        
        Node root = new Node(arr[0]);
        q.add(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        int idx = 1;
        
        while(idx != arr.length){
            Pair currNode = q.poll();
            
            if(arr[idx] < currNode.node.data && arr[idx] > currNode.min){
                currNode.node.left = new Node(arr[idx++]);
                q.add(new Pair(currNode.node.left, currNode.min, currNode.node.data));
            }
            
            if(idx != arr.length && arr[idx] > currNode.node.data && arr[idx] < currNode.max){
                currNode.node.right = new Node(arr[idx++]);
                q.add(new Pair(currNode.node.right, currNode.node.data, currNode.max));
            }
        }
        
        return root;
    }
}
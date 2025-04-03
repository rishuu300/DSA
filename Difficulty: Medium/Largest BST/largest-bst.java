//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
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
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Info {
    int min;
    int max;
    int size;
    boolean isBST;
    
    Info(int min, int max, int size, boolean isBST){
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

class Solution {
    static Info largest1(Node root, int ans[]){
        if(root==null)
           return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE,0,true);

        Info left = largest1(root.left,ans);
        Info right = largest1(root.right,ans);
        
        Info curr = new Info(Integer.MAX_VALUE, Integer.MIN_VALUE,0,true);
        curr.min = Math.min(root.data,left.min);
        curr.max = Math.max(root.data,right.max);
        curr.size = 1 + left.size + right.size;
        
        if(left.isBST==true && right.isBST==true && (root.data>left.max && root.data<right.min))
           curr.isBST = true;
        else
           curr.isBST = false;
           
        if(curr.isBST)
           ans[0] = Math.max(ans[0],curr.size);
           
        return curr;
    }
    
    static int largestBst(Node root) {
        int ans[] = {0};
        largest1(root, ans);
        return ans[0];
    }
}
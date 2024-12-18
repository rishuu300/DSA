//{ Driver Code Starts
// Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            Stack<Integer> myStack = new Stack<>();
            int n = temp.length;
            // adding elements to the stack
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(temp[i]);
                myStack.push(x);
            }
            Solution obj = new Solution();
            obj.deleteMid(myStack);

            while (!myStack.isEmpty()) {
                System.out.print(myStack.peek() + " ");
                myStack.pop();
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void delete(Stack<Integer> s, int curr[], int n){
        if(s.isEmpty()){
            return;
        }
        
        int x = s.pop();
        
        curr[0]++;
        delete(s,curr,n);
        curr[0]--;
        
        if(curr[0] != Math.floor(n/2)){
           s.push(x);
        }
    }
    public void deleteMid(Stack<Integer> s) {
        int curr[] = {0};
        int n = s.size();
        delete(s,curr,n);
    }
}

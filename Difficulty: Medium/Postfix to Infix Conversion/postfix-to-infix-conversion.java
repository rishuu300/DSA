//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isOperand(char c){
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }
    
    static String postToInfix(String exp) {
        Stack<String> s = new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(isOperand(ch)){
                s.push(ch + "");
            }
            else{
                String op1 = s.pop();
                String op2 = s.pop();
                s.push("(" + op2 + ch + op1 + ")");
            }
        }
        
        return s.peek();
    }
}

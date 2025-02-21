//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public static boolean isPair(char c1, char c2){
        return (c1=='{' && c2=='}' || c1=='[' && c2==']' || c1=='(' && c2==')');
    }
    
    static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='{' || c=='[' || c=='('){
                s.push(c);
            }
            else{
                if(s.isEmpty())
                   return false;
                else if(!isPair(s.peek(),c))
                   return false;
                else
                   s.pop();
            }
        }
        return s.isEmpty();
    }
}

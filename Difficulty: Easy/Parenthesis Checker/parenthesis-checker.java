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
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isPair(char ch1, char ch2){
        return ((ch1 == '{' && ch2 == '}') || (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']'));
    }
    
    static boolean isParenthesisBalanced(String str) {
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '['){
                s.push(ch);
            }
            else{
                if(s.isEmpty() || !isPair(s.peek(), ch)){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }
        
        return s.isEmpty();
    }
}

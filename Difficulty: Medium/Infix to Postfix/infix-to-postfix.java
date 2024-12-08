//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int precedence(char ch){
        if(ch == '^'){
            return 3;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    public static String infixToPostfix(String str) {
        Stack<Character> s = new Stack<>();
        String res = "";
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                res += ch;
            }
            else if(ch == '('){
                s.push(ch);
            }
            else if(ch == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    res += s.pop();
                }
                s.pop();
            }
            else{
                while(!s.isEmpty() && precedence(ch) <= precedence(s.peek())){
                    res += s.pop();
                }
                s.push(ch);
            }
        }
        
        while(!s.isEmpty()){
            res += s.pop();
        }
        
        return res;
    }
}
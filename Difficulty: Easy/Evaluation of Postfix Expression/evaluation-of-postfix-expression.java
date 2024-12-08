//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


class Solution {
    public static boolean isOperand(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
    
    public static int evaluatePostFix(String S) {
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            
            if(isOperand(ch)){
                s.push(Character.getNumericValue(ch));
            }
            else{
                int op1 = s.pop();
                int op2 = s.pop();
                
                if(ch == '^'){
                    s.push(op2 ^ op1);
                }
                else if(ch == '/'){
                    s.push(op2 / op1);
                }
                else if(ch == '*'){
                    s.push(op2 * op1);
                }
                else if(ch == '+'){
                    s.push(op2 + op1);
                }
                else{
                    s.push(op2 - op1);
                }
            }
        }
        
        return s.peek();
    }
}
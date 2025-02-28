//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer>s = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            
            if(str.matches("-?\\d+")){
               s.push(Integer.parseInt(str));
            }
            else{
                int op1 = s.pop();
                int op2 = s.pop();
                
                if(str.equals("^")){
                   s.push(op2^op1);
                } 
                else if(str.equals("/")){
                    s.push(op2/op1);
                } 
                else if(str.equals("*")){
                    s.push(op2*op1);
                } 
                else if(str.equals("+")){
                    s.push(op2+op1);
                } 
                else{
                    s.push(op2-op1);
                }
            }
        }
        
        return s.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
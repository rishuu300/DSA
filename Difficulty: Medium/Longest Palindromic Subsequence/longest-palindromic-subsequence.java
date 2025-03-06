//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lcs(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] table = new int[n1+1][n2+1];
        
        for(int i1=1; i1<=n1; i1++){
            for(int i2=1; i2<=n2; i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1)){
                    table[i1][i2] = 1 + table[i1-1][i2-1];
                }
                else{
                    table[i1][i2] = Math.max(table[i1-1][i2], table[i1][i2-1]);
                }
            }
        }
        return table[n1][n2];
    }
    
    static int SO(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int prev[] = new int[n2+1];
        int temp[] = new int[n2+1];
        
        for(int i1=1; i1<=n1; i1++){
            for(int i2=1; i2<=n2; i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1)){
                    temp[i2] = 1 + prev[i2-1];
                }
                else{
                    temp[i2] = Math.max(prev[i2], temp[i2-1]);
                }
            }
            prev = temp.clone();
        }
        return prev[n2];
    }
    
    public int longestPalinSubseq(String S)
    {
        String reversed = new StringBuilder(S).reverse().toString();
        // return lcs(S,reversed);
        return SO(S,reversed);
    }
}
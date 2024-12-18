//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean knows(int mat[][], int a, int b){
        return mat[a][b] == 1;
    }
    
    public int celebrity(int mat[][]) {
        Stack<Integer> s = new Stack<>();
        int n = mat.length;
        
        for(int i=0; i<n; i++){
            s.push(i);
        }
        
        while(s.size() > 1){
            int a = s.pop();
            int b = s.pop();
            
            if(knows(mat, a, b)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        
        int celeb = s.peek();
        
        int zeros = 0, ones = 0;
        for(int i=0; i<n; i++){
            if(mat[celeb][i] == 0){
                zeros++;
            }
            
            if(mat[i][celeb] == 1){
                ones++;
            }
        }
        
        return (zeros == n && ones == n-1) ? celeb : -1;
    }
}
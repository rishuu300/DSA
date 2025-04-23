//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int row;
    int col;
    
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    static char[][] fill(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0; i<m; i++){
            if(mat[0][i] == 'O'){
                q.add(new Pair(0, i));
                visited[0][i] = true;
            }
            
            if(mat[n-1][i] == 'O'){
                q.add(new Pair(n-1, i));
                visited[n-1][i] = true;
            }
        }
        
        for(int i=0; i<n; i++){
            if(mat[i][0] == 'O'){
                q.add(new Pair(i, 0));
                visited[i][0] = true;
            }
            
            if(mat[i][m-1] == 'O'){
                q.add(new Pair(i, m-1));
                visited[i][m-1] = true;
            }
        }
        
        int drow[] = {+1, 0, -1, 0};
        int dcol[] = {0, -1, 0, +1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            
            for(int i=0; i<4; i++){
                int newRow = currRow + drow[i];
                int newCol = currCol + dcol[i];
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    !visited[newRow][newCol] && mat[newRow][newCol] == 'O'){
                    
                    q.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(mat[i][j] == 'O' && !visited[i][j]){
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
    }
}
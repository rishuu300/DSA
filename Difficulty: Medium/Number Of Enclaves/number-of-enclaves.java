//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
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
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0; i<m; i++){
            if(grid[0][i] == 1){
                q.add(new Pair(0, i));
                visited[0][i] = true;
            }
            
            if(grid[n-1][i] == 1){
                q.add(new Pair(n-1, i));
                visited[n-1][i] = true;
            }
        }
        
        for(int i=1; i<n-1; i++){
            if(grid[i][0] == 1){
                q.add(new Pair(i, 0));
                visited[i][0] = true;
            }
            
            if(grid[i][m-1] == 1){
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
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    
                    q.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        
        return count;
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Pair {
    int row;
    int col;
    int dist;
    
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    visited[i][j] = true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;
            
            res[row][col] = dist;
            
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                   !visited[nrow][ncol]){
                    
                    visited[nrow][ncol] = true;   
                    q.add(new Pair(nrow,ncol,dist+1));
                }
            }
        }
        
        return res;
    }
}
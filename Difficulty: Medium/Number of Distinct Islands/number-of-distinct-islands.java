//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
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
    String BFS(int grid[][], boolean visited[][], int baseRow, int baseCol){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        StringBuilder shape = new StringBuilder();
        
        q.add(new Pair(baseRow, baseCol));
        
        int drow[] = {+1, 0, -1, 0};
        int dcol[] = {0, -1, 0, +1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            
            for(int i=0; i<4; i++){
                int newRow = currRow + drow[i];
                int newCol = currCol + dcol[i];
                
                shape.append((currRow - baseRow) + ":" + (currCol - baseCol));
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    
                    q.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return shape.toString();
    }
    
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashSet<String> set = new HashSet<>();
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    String shape = BFS(grid, visited, i, j);
                    set.add(shape);
                }
            }
        }
        
        return set.size();
    }
}
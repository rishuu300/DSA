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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
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
    int dist;
    
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        int dist[][] = new int[n][m];
        
        for(int arr[] : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        q.add(new Pair(source[0], source[1], 0));
        dist[source[0]][source[1]] = 0;
        
        int drow[] = {+1, 0, -1, 0};
        int dcol[] = {0, -1, 0, +1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDist = curr.dist;
            
            for(int i=0; i<4; i++){
                int newRow = currRow + drow[i];
                int newCol = currCol + dcol[i];
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 1 && currDist + 1 < dist[newRow][newCol]){
                    
                    dist[newRow][newCol] = currDist + 1;
                    q.add(new Pair(newRow, newCol, currDist + 1));
                    
                    if(newRow == destination[0] && newCol == destination[1]){
                        return currDist + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}
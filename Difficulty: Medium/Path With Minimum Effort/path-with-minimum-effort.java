//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair> {
    int row, col, effort;
    
    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
    
    public int compareTo(Pair other) {
        return this.effort - other.effort;
    }
}

class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        int[][] dist = new int[rows][columns];
        for (int[] arr : dist)
            Arrays.fill(arr, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        
        int[] drow = {+1, 0, -1, 0};
        int[] dcol = {0, -1, 0, +1};
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row, c = curr.col, effort = curr.effort;
            
            if (r == rows - 1 && c == columns - 1)
                return effort;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i], nc = c + dcol[i];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < columns) {
                    int diff = Math.abs(heights[nr][nc] - heights[r][c]);
                    int newEffort = Math.max(effort, diff);
                    
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }
        
        return 0;
    }
}

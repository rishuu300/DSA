//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int colors[], int currNode, int color){
        colors[currNode] = color;
        
        for(int node : adj.get(currNode)){
            if(colors[node] == -1){
                if(!dfs(adj, colors, node, 1-color)){
                    return false;
                }
            }
            else if(colors[node] == color){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int colors[] = new int[V];
        Arrays.fill(colors, -1);
        
        for(int i=0; i<V; i++){
            if(colors[i] == -1){
                if(!dfs(adj, colors, i, 0)){
                    return false;
                }
            }
        }
        
        return true;
    }
}
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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isCycle(List<List<Integer>> adj, boolean visited[], boolean path[], int currNode){
        visited[currNode] = true;
        path[currNode] = true;
        
        for (int node : adj.get(currNode)) {
            if (!visited[node]) {
                if (isCycle(adj, visited, path, node)) {
                    return true;
                }
            } else if (path[node]) {
                return true;
            }
        }
        
        path[currNode] = false;
        return false;
    }
    
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>();
        
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!isCycle(adj, visited, path, i)) {
                list.add(i);
            }
        }
        
        return list;
    }
}

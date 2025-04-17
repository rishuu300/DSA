//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findMinCycle(int V, int[][] edges) {
        final int INF = (int) 1e9;
        int[][] dist = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        int minCycle = INF;
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            int original = dist[u][v];
            dist[u][v] = dist[v][u] = INF;
            
            int[][] shortest = new int[V][V];
            for (int i = 0; i < V; i++)
                shortest[i] = dist[i].clone();
                
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (shortest[i][k] < INF && shortest[k][j] < INF)
                            shortest[i][j] = Math.min(shortest[i][j], shortest[i][k] + shortest[k][j]);
                    }
                }
            }
            
            if (shortest[u][v] < INF) {
                minCycle = Math.min(minCycle, shortest[u][v] + w);
            }
            
            dist[u][v] = dist[v][u] = original;
        }
        
        return (minCycle == INF) ? -1 : minCycle;
    }
};
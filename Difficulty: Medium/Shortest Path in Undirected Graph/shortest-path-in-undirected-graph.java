//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Pair {
    int vtx;
    int wt;
    
    Pair(int vtx, int wt){
        this.vtx = vtx;
        this.wt = wt;
    }
}

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        boolean visited[] = new boolean[V];
        
        pq.add(new Pair(src, 0));
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int vtx = curr.vtx;
            int wt = curr.wt;
            
            visited[vtx] = true;
            dist[vtx] = wt;
            
            for(int i : adj.get(vtx)){
                if(!visited[i]){
                    if(dist[vtx] + 1 < dist[i]){
                        dist[i] = dist[vtx] + 1;
                        pq.add(new Pair(i, dist[i]));
                    }
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}

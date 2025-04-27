//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int vtx;
    int wt;
    
    Pair(int vtx, int wt){
        this.vtx = vtx;
        this.wt = wt;
    }
}

class Solution {
    List<Integer> topoSort(List<List<Pair>> adj, int V) {
        int inDegree[] = new int[V];
        
        for(int i=0; i<V; i++){
            for(Pair j : adj.get(i)){
                inDegree[j.vtx]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(inDegree[i] == 0){
               q.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);
            
            for(Pair j : adj.get(curr)){
                inDegree[j.vtx]--;
                
                if(inDegree[j.vtx] == 0){
                   q.add(j.vtx);
                }
            }
        }
        
        return result;
    }
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new Pair(v,w));
        }
        
        List<Integer> path = topoSort(adj, V);
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        for(int i=0; i<V; i++){
            int currVtx = path.get(i);
            
            if(dist[currVtx] != Integer.MAX_VALUE){
                for(Pair vtx : adj.get(currVtx)){
                    int u = vtx.vtx;
                    int w = vtx.wt;
                    
                    if(dist[currVtx] + w < dist[u]){
                        dist[u] = dist[currVtx] + w;
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
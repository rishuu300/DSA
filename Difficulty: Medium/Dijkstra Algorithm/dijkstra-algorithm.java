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

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Pair {
    int v;
    int w;
    
    Pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new Pair(v, w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int dist[] = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(src, 0));
        dist[src] = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.v;
            
            for(Pair i : adj.get(currNode)){
                int adjNode = i.v;
                int adjWt = i.w;
                
                if(dist[currNode] + adjWt < dist[adjNode]){
                    dist[adjNode] = dist[currNode] + adjWt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        
        return dist;
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair {
    int v;
    int w;
    
    Pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

class Tuple {
    int vertex;
    int weight;
    int stops;
    
    Tuple(int vertex, int weight, int stops){
        this.vertex = vertex;
        this.weight = weight;
        this.stops = stops;
    }
}

class Solution {
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        if(src == dst){
            return -1;
        }
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            
            adj.get(u).add(new Pair(v,w));
        }
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src, 0, 0));
        dist[src] = 0;
        
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int currNode = curr.vertex;
            int currWeight = curr.weight;
            int currStops = curr.stops;
            
            if(currStops > k) continue;
            
            for(Pair neighbor :  adj.get(currNode)){
                int adjNode = neighbor.v;
                int adjWeight = neighbor.w;
                
                if(currWeight + adjWeight < dist[adjNode] && currStops <= k){
                    dist[adjNode] = currWeight + adjWeight;
                    q.add(new Tuple(adjNode, currWeight + adjWeight, currStops+1));
                }
            }
        }
        
        return (dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst]);
    }
}
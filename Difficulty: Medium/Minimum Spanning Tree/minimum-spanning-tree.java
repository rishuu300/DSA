//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
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
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean visited[] = new boolean[V];
        
        pq.add(new Pair(0,0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.v;
            int currWeight = curr.w;
            
            if(visited[currNode]){
                continue;
            }
            
            visited[currNode] = true;
            sum += currWeight;
            
            for(int[] neighbor : adj.get(currNode)){
                int adjNode = neighbor[0];
                int adjWeight = neighbor[1];
                
                if(!visited[adjNode]){
                    pq.add(new Pair(adjNode, adjWeight));
                }
            }
        }
        
        return sum;
    }
}
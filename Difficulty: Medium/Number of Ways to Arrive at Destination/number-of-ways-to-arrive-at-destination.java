//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int v;
    long w;
    
    Pair(int v, long w){
        this.v = v;
        this.w = w;
    }
}

class Solution {
    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.size(); i++){
            int u = roads.get(i).get(0);
            int v = roads.get(i).get(1);
            int w = roads.get(i).get(2);
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        long dist[] = new long[n];
        int ways[] = new int[n];
        
        for(int i=0; i<n; i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        
        pq.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;
        
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.v;
            long currWeight = curr.w;
            
            for(Pair neighbor : adj.get(currNode)){
                int adjNode = neighbor.v;
                long adjWeight = neighbor.w;
                
                if(currWeight + adjWeight < dist[adjNode]){
                    dist[adjNode] = currWeight + adjWeight;
                    ways[adjNode] = ways[currNode];
                    pq.add(new Pair(adjNode, (int)(currWeight + adjWeight)));
                }
                else if(currWeight + adjWeight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) % mod;
                }
            }
        }
        
        return ways[n-1] % mod;
    }
}

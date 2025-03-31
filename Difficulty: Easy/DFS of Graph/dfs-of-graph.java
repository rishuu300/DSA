//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean visited[] = new boolean[V];
        DFS(adj,res,visited,0);
        return res;
    }
    
    void DFS(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, boolean visited[], int s){
        visited[s] = true;
        res.add(s);
        
        for(int i : adj.get(s)){
            if(visited[i]==false){
               DFS(adj,res,visited,i);
            }
        }
    }
}
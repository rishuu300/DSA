//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void DFS(ArrayList<ArrayList<Integer>> adj, boolean visited[], int parent, int curr){
        visited[curr] = true;
        
        for(int i : adj.get(curr)){
            if(!visited[i]){
                DFS(adj, visited, curr, i);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> mat, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(mat.get(i).get(j) == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        boolean visited[] = new boolean[V];
        int count = 0;
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                count++;
                DFS(adj, visited, i, i);
            }
        }
        
        return count;
    }
};
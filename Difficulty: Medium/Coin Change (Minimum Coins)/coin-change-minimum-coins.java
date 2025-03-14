//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    int rec(int coins[], int V, int idx, int n){
        if(idx==n-1){
            if(V%coins[idx]==0)
                return V/coins[idx];
            return (int)1e9;
        }
        
        int notPick = rec(coins,V,idx+1,n);
        int pick = Integer.MAX_VALUE;
        if(coins[idx]<=V){
            pick = 1 + rec(coins,V - coins[idx],idx,n);
        }
        
        return Math.min(notPick,pick);
    }
    
    int memo(int[] coins, int V, int idx, int n, int memo[][]){
        if(idx==n-1){
            if(V%coins[idx]==0)
                return V/coins[idx];
            return (int)1e9;
        }
        
        if(memo[idx][V] != 0){
            return memo[idx][V];
        }
        
        int notPick = memo(coins,V,idx+1,n,memo);
        int pick = Integer.MAX_VALUE;
        if(coins[idx]<=V){
            pick = 1 + memo(coins,V - coins[idx],idx,n,memo);
        }
        
        return memo[idx][V] = Math.min(notPick,pick);
    }
    
    int table(int[] coins, int V, int n){
        int table[][] = new int[n][V+1];
        
        for(int target=0; target<=V; target++){
            if(target%coins[n-1] == 0){
                table[n-1][target] = target/coins[n-1];
            }
            else{
                table[n-1][target] = (int)1e9;
            }
        }
        
        for(int idx=n-2; idx>=0; idx--){
            for(int target=0; target<=V; target++){
                int notPick = table[idx+1][target];
                int pick = Integer.MAX_VALUE;
                if(coins[idx]<=target ){
                    pick = 1 + table[idx][target-coins[idx]];
                }
                
                table[idx][target] = Math.min(pick,notPick);
            }
        }
        
        return table[0][V];
    }
    
    int SO(int[] coins, int V, int n){
        int prev[] = new int[V+1];
        int temp[] = new int[V+1];
        
        for(int target=0; target<=V; target++){
            if(target%coins[n-1] == 0){
                prev[target] = target/coins[n-1];
            }
            else{
                prev[target] = (int)1e9;
            }
        }
        
        for(int idx=n-2; idx>=0; idx--){
            for(int target=0; target<=V; target++){
                int notPick = prev[target];
                int pick = Integer.MAX_VALUE;
                if(coins[idx]<=target ){
                    pick = 1 + temp[target-coins[idx]];
                }
                
                temp[target] = Math.min(pick,notPick);
            }
            prev = temp.clone();
        }
        
        return prev[V];
    }
    
    public int minCoins(int coins[], int V) {
        int M = coins.length;
        // int[][] memo = new int[M][V+1];
        // int res = memo(coins,V,0,M,memo);
        //int res = table(coins,V,M);
        int res = SO(coins,V,M);
        return (res >= (int)1e9) ? -1 : res;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
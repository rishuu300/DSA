//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int rec(int[] wt, int[] val, int W, int idx){
        if(idx==0){
            if(wt[idx]<=W){
                return val[idx];
            }
            return 0;
        }
        
        int notPick = rec(wt,val,W,idx-1);
        int pick = Integer.MIN_VALUE;
        if(wt[idx]<=W){
            pick = val[idx] + rec(wt,val,W-wt[idx],idx-1);
        }
        
        return Math.max(notPick,pick);
    }
    
    public static int memo(int[] wt, int[] val, int W, int idx, int[][] memo){
        if(idx==0){
            if(wt[idx]<=W){
                return val[idx];
            }
            return 0;
        }
        
        if(memo[idx][W] != 0){
            return memo[idx][W];
        }
        
        int notPick = memo(wt,val,W,idx-1,memo);
        int pick = Integer.MIN_VALUE;
        if(wt[idx]<=W){
            pick = val[idx] + memo(wt,val,W-wt[idx],idx-1,memo);
        }
        
        return memo[idx][W] = Math.max(notPick,pick);
    }
    
    public static int table(int[] wt, int[] val, int W, int n){
        int[][] table = new int[n][W+1];
        for(int i=wt[0]; i<=W; i++){
            table[0][i] = val[0];
        }
        
        for(int idx=1; idx<n; idx++){
            for(int cap=0; cap<=W; cap++){
                int notPick = table[idx-1][cap];
                int pick = Integer.MIN_VALUE;
                
                if(wt[idx]<=cap){
                    pick = val[idx] + table[idx-1][cap-wt[idx]];
                }
                
                table[idx][cap] = Math.max(pick,notPick);
            }
        }
        
        return table[n-1][W];
    }
    
    public static int SO(int[] wt, int[] val, int W, int n){
        int prev[] = new int[W+1];
        int temp[] = new int[W+1];
        for(int i=wt[0]; i<=W; i++){
            prev[i] = val[0];
        }
        
        for(int idx=1; idx<n; idx++){
            for(int cap=0; cap<=W; cap++){
                int notPick = prev[cap];
                int pick = Integer.MIN_VALUE;
                
                if(wt[idx]<=cap){
                    pick = val[idx] + prev[cap-wt[idx]];
                }
                
                temp[cap] = Math.max(pick,notPick);
            }
            prev = temp.clone();
        }
        return prev[W];
    }
    
    public static int SSO(int[] wt, int[] val, int W, int n){
        int prev[] = new int[W+1];
        for(int i=wt[0]; i<=W; i++){
            prev[i] = val[0];
        }
        
        for(int idx=1; idx<n; idx++){
            for(int cap=W; cap>=0; cap--){
                int notPick = prev[cap];
                int pick = Integer.MIN_VALUE;
                
                if(wt[idx]<=cap){
                    pick = val[idx] + prev[cap-wt[idx]];
                }
                
                prev[cap] = Math.max(pick,notPick);
            }
        }
        return prev[W];
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        // int[][] memo = new int[n][W+1];
        // return memo(wt,val,W,n-1,memo);
        // return table(wt,val,W,n);
        return SSO(wt,val,W,n);
    }
}

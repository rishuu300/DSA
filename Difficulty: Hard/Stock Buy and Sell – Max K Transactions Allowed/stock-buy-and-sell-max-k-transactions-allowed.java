//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int rec(int prices[], int idx, int buy, int k, int n){
        if(k==0 || idx==n){
            return 0;
        }
        
        if(buy==1){
            return Math.max(-prices[idx] + rec(prices,idx+1,0,k,n), rec(prices,idx+1,1,k,n));
        }
        else{
            return Math.max(prices[idx] + rec(prices,idx+1,1,k-1,n), rec(prices,idx+1,0,k,n));
        }
    }
    
    static int memo(int[] prices, int idx, int buy, int k, int n, int memo[][][]){
        if(k==0 || idx==n){
            return 0;
        }
        
        if(memo[idx][buy][k] != -1){
            return memo[idx][buy][k];
        }
        
        if(buy==1){
            return memo[idx][buy][k] = Math.max(-prices[idx] + memo(prices,idx+1,0,k,n,memo), 
                                                memo(prices,idx+1,1,k,n,memo));
        }
        else{
            return memo[idx][buy][k] = Math.max(prices[idx] + memo(prices,idx+1,1,k-1,n,memo), 
                                                memo(prices,idx+1,0,k,n,memo));
        }
    }
    
    static int table(int[] prices, int n, int k){
        int[][][] table = new int[n+1][2][k+1];
        
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int count=1; count<=k; count++){
                    if(buy==1){
                        int Buy = -prices[idx] + table[idx+1][0][count];
                        int notBuy = table[idx+1][1][count];
                        
                        table[idx][buy][count] = Math.max(Buy,notBuy);
                    }
                    else{
                        int sell = prices[idx] + table[idx+1][1][count-1];
                        int notSell = table[idx+1][0][count];
                        
                        table[idx][buy][count] = Math.max(sell,notSell);
                    }
                }
            }
        }
        
        return table[0][1][k];
    }
    
    static int SO(int[] prices, int n, int k){
        int[][] prev = new int[2][k+1];
        int[][] temp = new int[2][k+1];
        
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int count=1; count<=k; count++){
                    if(buy==1){
                        int Buy = -prices[idx] + prev[0][count];
                        int notBuy = prev[1][count];
                        
                        temp[buy][count] = Math.max(Buy,notBuy);
                    }
                    else{
                        int sell = prices[idx] + prev[1][count-1];
                        int notSell = prev[0][count];
                        
                        temp[buy][count] = Math.max(sell,notSell);
                    }
                }
            }
            prev = temp.clone();
        }
        
        return prev[1][k];
    }
    
    static int maxProfit(int prices[], int K) {
        int N = prices.length;
        // int[][][] memo = new int[N][2][K+1];
        // for(int i[][] : memo){
        //     for(int j[] : i){
        //         Arrays.fill(j,-1);
        //     }
        // }
        // return memo(prices,0,1,K,N,memo);
        
        // return table(prices,N,K);
        return SO(prices,N,K);
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int rec(int[] prices, int count, int buy, int idx, int n){
        if(count==0 || idx==n){
            return 0;
        }
        
        if(buy==1){
            return Math.max(-prices[idx] + rec(prices,count,0,idx+1,n), rec(prices,count,1,idx+1,n));
        }
        else{
            return Math.max(prices[idx] + rec(prices,count-1,1,idx+1,n), rec(prices,count,0,idx+1,n));
        }
    }
    
    public static int memo(int[] prices, int idx, int buy, int count, int n, int[][][] memo){
        if(count==0 || idx==n){
            return 0;
        }
        
        if(memo[idx][buy][count] != -1){
            return memo[idx][buy][count];
        }
        
        if(buy==1){
            int Buy = -prices[idx] + memo(prices,idx+1,0,count,n,memo);
            int notBuy = memo(prices,idx+1,1,count,n,memo);
            
            return memo[idx][buy][count] = Math.max(Buy,notBuy);
        }
        else{
            int sell = prices[idx] + memo(prices,idx+1,1,count-1,n,memo);
            int notSell = memo(prices,idx+1,0,count,n,memo);
            
            return memo[idx][buy][count] = Math.max(sell,notSell);
        }
        
    }
    
    public static int table(int[] prices, int n){
        int[][][] table = new int[n+1][2][3];
        
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int count=1; count<=2; count++){
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
        
        return table[0][1][2];
    }
    
    public static int SO(int[] prices, int n){
        int[][] prev = new int[2][3];
        int[][] temp = new int[2][3];
        
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int count=1; count<=2; count++){
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
        
        return prev[1][2];
    }
    
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] memo = new int[n][2][3];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 2; j++){
        //         Arrays.fill(memo[i][j], -1);
        //     }
        // }
        // return memo(prices,0,1,2,n,memo);
        
        // return table(prices,n);
        return SO(prices,n);
    }
}

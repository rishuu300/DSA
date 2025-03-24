//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int rec(int arr[], int n, int i, int j){
        if(i==j){
            return 0;
        }
        
        int min = (int)1e9;
        for(int idx=i; idx<j; idx++){
            int steps = (arr[i-1] * arr[idx] * arr[j]) +
                        rec(arr,n,i,idx) + rec(arr,n,idx+1,j);
                        
            min = Math.min(min, steps);
        }
        
        return min;
    }
    
    static int memo(int arr[], int n, int i, int j, int[][] memo){
        if(i==j){
            return 0;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int min = (int)1e9;
        for(int idx=i; idx<j; idx++){
            int steps = (arr[i-1] * arr[idx] * arr[j]) +
                        memo(arr,n,i,idx,memo) + memo(arr,n,idx+1,j,memo);
                        
            min = Math.min(min, steps);
        }
        
        return memo[i][j] = min;
    }
    
    static int table(int arr[], int n){
        int[][] table = new int[n][n];
        
        for(int st=n-1; st>=1; st--){
            for(int end=st+1; end<n; end++){
                
                int min = (int)1e9;
                for(int part=st; part<end; part++){
                    int steps = (arr[st-1] * arr[part] * arr[end])
                                + table[st][part] + table[part+1][end];
                                
                    min = Math.min(min,steps);
                }
                
                table[st][end] = min;
            }
        }
        
        return table[1][n-1];
    }
    
    static int matrixMultiplication(int arr[]) {
        int N = arr.length;
        // int[][] memo = new int[N][N];
        // for(int i[] : memo){
        //     Arrays.fill(i,-1);
        // }
        // return memo(arr,N,1,N-1,memo);
        
        return table(arr,N);
    }
}
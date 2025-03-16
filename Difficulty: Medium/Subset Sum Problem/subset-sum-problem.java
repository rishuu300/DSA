//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean rec(int arr[], int sum, int idx){
        if(sum==0){
            return true;
        }
        
        if(idx==0){
            return sum==arr[0];
        }
        
        boolean pick = false;
        if(sum>=arr[idx]){
            pick = rec(arr,sum-arr[idx],idx-1);
        }
        
        if(pick){
            return true;
        }
        
        return rec(arr,sum,idx-1);
        
    }
    
    public static boolean memo(int arr[], int sum, int idx, int[][] memo){
        if(sum==0){
            return true;
        }
        
        if(idx==0){
            return sum==arr[0];
        }
        
        if(memo[idx][sum] != -1){
            return memo[idx][sum]==1;
        }
        
        boolean pick = false;
        if(sum>=arr[idx]){
            pick = memo(arr,sum-arr[idx],idx-1,memo);
        }
        
        if(pick){
            memo[idx][sum] = 1;
            return true;
        }
        else{
            memo[idx][sum] = 0;
        }
        
        memo[idx][sum] = (memo(arr,sum,idx-1,memo)) ? 1 : 0;
        return memo[idx][sum]==1;
    }
    
    public static boolean table(int arr[], int sum, int N){
        boolean[][] table = new boolean[N][sum+1];
        for(int i=0; i<N; i++){
            table[i][0] = true;
        }
        if(arr[0]<=sum)
            table[0][arr[0]] = true;
        
        for(int idx=1; idx<N; idx++){
            for(int target=1;target<=sum; target++){
                boolean notPick = table[idx-1][target];
                
                boolean pick = false;
                if(arr[idx]<=target){
                    pick = table[idx-1][target-arr[idx]];
                }
                
                table[idx][target] = pick | notPick;
            }
        }
        return table[N-1][sum];
    }
    
    public static boolean SO(int[] arr, int sum, int N){
        boolean[] prev = new boolean[sum+1];
        boolean[] temp = new boolean[sum+1];
        prev[0] = true;
        temp[0] = true;
        
        if(arr[0]<=sum){
            prev[arr[0]] = true;
        }
        
        for(int idx=1; idx<N; idx++){
            for(int target=1;target<=sum; target++){
                boolean notPick = prev[target];
                
                boolean pick = false;
                if(arr[idx]<=target){
                    pick = prev[target-arr[idx]];
                }
                
                temp[target] = pick | notPick;
            }
            prev = temp.clone();
        }
        return prev[sum];
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        int N = arr.length;
        // int[][] memo = new int[N][sum+1];
        // for(int i[] : memo){
        //     Arrays.fill(i,-1);
        // }
        // return memo(arr,sum,N-1,memo);
        // return table(arr,sum,N);
        return SO(arr,sum,N);
    }
}
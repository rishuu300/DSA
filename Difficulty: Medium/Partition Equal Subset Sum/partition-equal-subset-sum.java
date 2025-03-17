//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean solve(int[] arr, int sum, int N){
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
    
    static boolean equalPartition(int arr[]) {
        int N = arr.length;
        int totalSum = 0;
        for(int i=0; i<N; i++){
            totalSum += arr[i];
        }
        
        int target = totalSum/2;
        
        if(totalSum%2 != 0)return false;
        
        return solve(arr,target,N);
    }
}
//{ Driver Code Starts
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

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int SO(int arr[], int n){
        int prev1 = arr[n];
        int prev2 = 0;
        
        for(int i=n-1; i>=0; i--){
            int pick = arr[i] + prev2;
            int notPick = prev1;
            
            int curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    
    public int findMaxSum(int arr[]) {
        return SO(arr, arr.length-1);
    }
}
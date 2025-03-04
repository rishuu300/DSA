//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int rec(int[] arr, int n, int idx, int prev){
		if(idx==n){
			return 0;
		}
		
		int notTake = rec(arr,n,idx+1,prev);
		int take = 0;
		if(prev==-1 || arr[idx]>arr[prev]){
			take = 1 + rec(arr,n,idx+1,idx);
		}
		
		return Math.max(take, notTake);
	}

	public static int memo(int[] arr, int n, int idx, int prev, int[][] memo){
		if(idx==n){
			return 0;
		}
		
		if(memo[idx][prev+1] != -1){
			return memo[idx][prev+1];
		}
		
		int notTake = memo(arr,n,idx+1,prev,memo);
		int take = 0;
		if(prev==-1 || arr[idx]>arr[prev]){
			take = 1 + memo(arr,n,idx+1,idx,memo);
		}
		
		return memo[idx][prev+1] = Math.max(take, notTake);
	}

	public static int table(int[] arr, int n){
		int[][] table = new int[n+1][n+1];
		
		for(int idx=n-1; idx>=0; idx--){
			for(int prev=idx-1; prev>=-1; prev--){
				int notTake = table[idx+1][prev+1];
				int take = 0;
				if(prev==-1 || arr[idx]>arr[prev]){
					take = 1 + table[idx+1][idx+1];
				}
				
				
				table[idx][prev+1] = Math.max(notTake,take);
			}
		}
		
		return table[0][0];
	}

	public static int SO(int[] arr, int n){
		int next[] = new int[n+1];
		int temp[] = new int[n+1];
		
		for(int idx=n-1; idx>=0; idx--){
			for(int prev=idx-1; prev>=-1; prev--){
				int notTake = next[prev+1];
				int take = 0;
				if(prev==-1 || arr[idx]>arr[prev]){
					take = 1 + next[idx+1];
				}
				
				temp[prev+1] = Math.max(take,notTake);
			}
			next = temp.clone();
		}
		
		
		return next[0];
	}

	public static int SSO(int[] arr, int n){
		int dp[] = new int[n];
		int max = 1;
		Arrays.fill(dp,1);
		
		for(int idx=0; idx<n; idx++){
			for(int prev=0; prev<idx; prev++){
				if(arr[idx]>arr[prev]){
					dp[idx] = Math.max(dp[idx], 1+dp[prev]);
					max = Math.max(max, dp[idx]);
				}
			}
		}
		
		return max;
	}

	public static int BS(int[] arr, int n){
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(arr[0]);
		
		for(int i=1;  i<n; i++){
			if(arr[i] > temp.get(temp.size() - 1)){
				temp.add(arr[i]);
			}
			else{
				int idx  = Collections.binarySearch(temp, arr[i]);
				if(idx<0){
					idx = -idx-1;
				}
				
				temp.set(idx,arr[i]);
			}
		}
		
		return temp.size();
	}
    
    static int lis(int arr[]) {
        int n = arr.length;
        //int[][] memo = new int[n][n+1];
		//for(int i[] : memo){
		//	Arrays.fill(i,-1);
		//}
		//return memo(arr,arr.length,0,-1,memo);
		
		// return table(arr,n);
		// return  SO(arr,n);
		// return SSO(arr,n);
		return BS(arr,n);
    }
}
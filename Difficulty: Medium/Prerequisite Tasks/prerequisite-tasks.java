//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		
System.out.println("~");
}
	}
	
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < P; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            adj.get(u).add(v);
        }
        
        int inDegree[] = new int[N];
        
        for(int i=0; i<N; i++){
            for(int j : adj.get(i)){
                inDegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            
            for(int i : adj.get(curr)){
                inDegree[i]--;
                
                if(inDegree[i] == 0){
                    q.add(i);
                }
            }
        }
        
        return count == N;
    }
}
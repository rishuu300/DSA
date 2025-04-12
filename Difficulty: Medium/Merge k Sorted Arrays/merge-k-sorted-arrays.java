//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java

class Info {
    int data;
    int position;
    int arrayValue;
    
    Info(int data, int position, int arrayValue){
        this.data = data;
        this.position = position;
        this.arrayValue = arrayValue;
    }
}

class Solution {
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<K; i++){
            pq.add(new Info(arr[i][0], 0, i));
        }
        
        while(!pq.isEmpty()){
            Info curr = pq.poll();
            int data = curr.data;
            int position = curr.position;
            int arrayValue = curr.arrayValue;
            
            al.add(data);
            
            if(position+1 < arr[arrayValue].length){
                pq.add(new Info(arr[arrayValue][position+1], position+1, arrayValue));
            }
        }
        
        return al;
    }
}
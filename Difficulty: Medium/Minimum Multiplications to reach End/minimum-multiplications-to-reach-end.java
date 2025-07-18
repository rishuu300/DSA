//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int vertex;
    int steps;
    
    Pair(int vertex, int steps){
        this.vertex = vertex;
        this.steps = steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        int dist[] = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.add(new Pair(start, 0));
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currNode = curr.vertex;
            int currSteps = curr.steps;
            
            for(int i : arr){
                int num = (currNode * i)%100000;
                
                if(num == end){
                    return currSteps + 1;
                }
                
                if(currSteps + 1 < dist[num]){
                    dist[num] = currSteps + 1;
                    q.add(new Pair(num, currSteps+1));
                }
            }
        }
        
        return -1;
    }
}

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] Intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(Intervals, (a,b) -> a[0] - b[0]);
        
        int curr[] = Intervals[0];
        result.add(curr);
        
        for(int i=1; i<Intervals.length; i++){
            int next[] = Intervals[i];
            
            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]);
            }
            else{
                curr = next;
                result.add(curr);
            }
        }
        
        return result;
    }
}
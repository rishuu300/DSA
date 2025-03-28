//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int N = start.length;
        int arr[][] = new int[N][3];
        
        for(int i=0; i<N; i++){
            arr[i][0] = i+1;
            arr[i][1] = start[i];
            arr[i][2] = finish[i];
        }
        
        Arrays.sort(arr, Comparator.comparingInt(o -> o[2]));
        
        int res = 1;
        int curr = arr[0][2];
        
        for(int i=1; i<N; i++){
            if(curr<arr[i][1]){
                res++;
                curr = arr[i][2];
            }
        }
        
        return res;
    }
}
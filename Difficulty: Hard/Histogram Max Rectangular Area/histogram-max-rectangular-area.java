//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int hist[]) {
        int n = hist.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && hist[i]<=hist[s.peek()]){
                int top = s.pop();
                int curr = hist[top] * ((s.isEmpty()) ? i : (i-s.peek()-1));
                res = Math.max(res,curr);
            }
            s.push((int)i);
        }
        
        while(!s.isEmpty()){
            int top = s.pop();
            int curr = hist[top] * ((s.isEmpty()) ? n : (n-s.peek()-1));
            res = Math.max(res,curr);
        }
        
        return res;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to calculate the span of stock's price for all n days.
    public ArrayList<Integer> calculateSpan(int[] prices) {
        int n = prices.length;
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> spans = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            spans.add(0);
        }
        
        s.push(0); spans.set(0, 1);
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && prices[i] >= prices[s.peek()]){
                s.pop();
            }
            
            int span = (s.isEmpty()) ? (i + 1) : (i - s.peek());
            
            spans.set(i, span);
            s.push(i);
        }
        
        return spans;
    }
}
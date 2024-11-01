//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        ArrayList<Long> rearranged = new ArrayList<>();
        
        int i = 0, j = n - 1;
        while (i <= j) {
            if (i == j) {
                rearranged.add(arr[i]);
            } else {
                rearranged.add(arr[i]);
                rearranged.add(arr[j]);
            }
            i++;
            j--;
        }
        
        long maxSum = 0;
        for (int k = 0; k < n - 1; k++) {
            maxSum += Math.abs(rearranged.get(k) - rearranged.get(k + 1));
        }
        
        maxSum += Math.abs(rearranged.get(n - 1) - rearranged.get(0));
        
        return maxSum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
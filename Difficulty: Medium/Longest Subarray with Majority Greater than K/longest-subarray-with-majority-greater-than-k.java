//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += (arr[i] > k) ? 1 : -1;

            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (!firstIndex.containsKey(prefixSum)) {
                    firstIndex.put(prefixSum, i);
                }

                if (firstIndex.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - firstIndex.get(prefixSum - 1));
                }
            }
        }

        return maxLen;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
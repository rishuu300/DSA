//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        int n = str.length();
        if (n == 0) return 0;
        
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int required = uniqueChars.size();
        
        int[] freq = new int[128];
        int start = 0, minLen = Integer.MAX_VALUE, count = 0;
        
        for (int end = 0; end < n; end++) {
            char endChar = str.charAt(end);
            freq[endChar]++;
            if (freq[endChar] == 1) count++;
            
            while (count == required) {
                minLen = Math.min(minLen, end - start + 1);
                
                char startChar = str.charAt(start);
                freq[startChar]--;
                if (freq[startChar] == 0) count--;
                start++;
            }
        }
        
        return minLen;
    }
}
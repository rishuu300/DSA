//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        if (s1 == null || s2 == null) return "0";
        
        // Step 1: Determine the sign
        boolean negative = false;
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }
        
        // Step 2: Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        
        // Special case: If any string becomes "0"
        if (s1.equals("0") || s2.equals("0")) return "0";
        
        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m]; // max possible size
        
        // Step 3: Multiply each digit
        for (int i = n - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int d2 = s2.charAt(j) - '0';
                int mul = d1 * d2;
                int sum = mul + result[i + j + 1];
                
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        
        // Step 4: Build the final string
        StringBuilder sb = new StringBuilder();
        
        // Skip any leading zeros in result array
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        
        // Add '-' if needed
        if (negative) {
            sb.insert(0, '-');
        }
        
        return sb.toString();
    }
    
    private String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
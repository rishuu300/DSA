//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        r = Math.min(r, n - r);  // Use symmetry
        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }

        return (int) result;
    }
}
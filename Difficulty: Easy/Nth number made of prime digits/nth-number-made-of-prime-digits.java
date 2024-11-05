//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.primeDigits(n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find nth number made of only prime digits.
    public static int primeDigits(int n) {
        int count = 0, number = 1;
        
        while (count < n) {
            if (hasOnlyPrimeDigits(number)) {
                count++;
            }
            number++;
        }
        return number - 1;
    }
    
    private static boolean hasOnlyPrimeDigits(int num) {
        while (num != 0) {
            int digit = num % 10;
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
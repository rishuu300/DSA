//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to compute the Longest Proper Prefix which is also Suffix (LPS) array
    void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; // length of the previous longest prefix suffix
        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1;      // start from the second character

        // Loop to compute the LPS array
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to search for the pattern in the given text
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int M = pat.length();
        int N = txt.length();

        int[] lps =
            new int[M +
                    1]; // lps array to store Longest Proper Prefix which is also Suffix

        int j = 0; // index for pattern

        computeLPSArray(pat, M, lps); // compute the LPS array

        int f = 0; // flag to track if the pattern was found
        int i = 0; // index for text

        // Loop to search for the pattern in the text
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                f++; // increment the flag
                res.add(
                    i -
                    j); // add the index where the pattern is found to the result list
                j = lps[j - 1]; // update j to continue searching for more occurrences
                                // of the pattern
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1]; // update j based on lps array
                else
                    i = i + 1; // increment i if j is 0
            }
        }

        return res; // return the result list
    }
}
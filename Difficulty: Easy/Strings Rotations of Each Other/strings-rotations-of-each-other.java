//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {

    public boolean KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = new int[M];
        
        computeLPSArray(pat, M, lps);
        
        int i = 0;
        int j = 0;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            
            if (j == M) {
                return true;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        
        lps[0] = 0;
        
        int i = 1;
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

    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        else {
            String concatenated = s1 + s1;
            if (KMPSearch(s2, concatenated))
                return true;
            else
                return false;
        }
    }
}
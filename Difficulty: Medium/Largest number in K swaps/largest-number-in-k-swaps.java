//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    String max = "";

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] chars = s.toCharArray();
        solve(chars, k, 0);
        return max;
    }

    private void solve(char[] s, int k, int index) {
        if (k == 0 || index == s.length)
            return;

        char maxDigit = s[index];
        for (int i = index + 1; i < s.length; i++) {
            if (s[i] > maxDigit) {
                maxDigit = s[i];
            }
        }

        if (maxDigit != s[index]) {
            for (int i = index + 1; i < s.length; i++) {
                if (s[i] == maxDigit) {
                    swap(s, i, index);
                    String current = new String(s);
                    if (current.compareTo(max) > 0) {
                        max = current;
                    }
                    solve(s, k - 1, index + 1);
                    swap(s, i, index); 
                }
            }
        } else {
            solve(s, k, index + 1); 
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
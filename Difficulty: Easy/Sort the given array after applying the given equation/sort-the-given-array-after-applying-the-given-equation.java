//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        int i = 0, j = n - 1;
        int index = A >= 0 ? n - 1 : 0;

        while (i <= j) {
            int val_i = compute(arr[i], A, B, C);
            int val_j = compute(arr[j], A, B, C);

            if (A >= 0) {
                if (val_i > val_j) {
                    result.set(index--, val_i);
                    i++;
                } else {
                    result.set(index--, val_j);
                    j--;
                }
            } else {
                if (val_i < val_j) {
                    result.set(index++, val_i);
                    i++;
                } else {
                    result.set(index++, val_j);
                    j--;
                }
            }
        }

        return result;
    }

    private int compute(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(n);
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<n; i++){
            res.add(0);
        }
        
        s.push(arr[n-1]); res.set(n-1, -1);
        
        for(int i=n-2; i>=0; i--){
            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }
            
            int element = (s.isEmpty()) ? -1 : s.peek();
            res.set(i, element);
            s.push(arr[i]);
        }
        
        return res;
    }
}
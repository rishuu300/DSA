//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 3 != 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }
        
        int targetSum = totalSum / 3;
        int currentSum = 0;
        int count = 0;
        int i = -1, j = -1;
        
        for (int k = 0; k < arr.length; k++) {
            currentSum += arr[k];
            
            if (currentSum == targetSum) {
                count++;
                if (count == 1) {
                    i = k;
                } else if (count == 2) {
                    j = k;
                    break;
                }
                currentSum = 0;
            }
        }
        
        if (i != -1 && j != -1) {
            result.add(i);
            result.add(j);
        } else {
            result.add(-1);
            result.add(-1);
        }
        
        return result;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                int top = s.pop();
                int range = (s.isEmpty()) ? i : i-s.peek()-1;
                ans.set(range-1, Math.max(ans.get(range-1), arr[top]));
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int top = s.pop();
            int range = (s.isEmpty()) ? n : n-s.peek()-1;
            ans.set(range-1, Math.max(ans.get(range-1), arr[top]));
        }
        
        for(int i=n-2; i>=0; i--){
            ans.set(i, Math.max(ans.get(i),ans.get(i+1)));
        }
        
        return ans;
    }
}
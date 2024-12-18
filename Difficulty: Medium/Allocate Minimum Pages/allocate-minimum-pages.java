//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int m) {
        int n = arr.length;
        
        if(n<m){
            return -1;
        }
        
        int low = arr[0];
        int high = arr[0];
        
        for(int i=1; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        
        while(low <= high){
            int mid = (low+high)/2;
            
            int student_count = count_students(arr, mid);
            if(student_count > m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
    
    public static int count_students(int arr[], int pages){
        int students = 1;
        long pages_count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(pages_count + arr[i] <= pages){
                pages_count += arr[i];
            }
            else{
                students++;
                pages_count = arr[i];
            }
        }
        
        return students;
    }
}
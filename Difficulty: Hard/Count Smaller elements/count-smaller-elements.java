//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void mergeSort(int v[][], int ans[], int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(v,ans,low,mid);
            mergeSort(v,ans,mid+1,high);
            merge(v,ans,low,mid,high);
        }
    }
    
    void merge(int v[][], int ans[], int low, int mid, int high){
        int t[][] = new int[high-low+1][2];
        int i = low;
        int j = mid+1;
        int k = 0;
        
        while(i<=mid && j<=high){
            if(v[i][0]>v[j][0]){
                ans[v[i][1]] += (high-j+1);
                t[k][0] = v[i][0];
                t[k][1] = v[i][1];
                i++;k++;
            }
            else{
                t[k][0] = v[j][0];
                t[k][1] = v[j][1];
                j++;k++;
            }
        }
        
        while(i<=mid){
            t[k][0] = v[i][0];
            t[k][1] = v[i][1];
            i++;k++;
        }
            
        while(j<=high){
            t[k][0] = v[j][0];
            t[k][1] = v[j][1];
            j++;k++;
        }
        
        k=0;
        for(i=low; i<=high; i++, k++){
            v[i][0] = t[k][0];
            v[i][1] = t[k][1];
        }
    }
    
    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int v[][] = new int[n][2];
        
        for(int i=0; i<n; i++){
            v[i][0] = arr[i];
            v[i][1] = i;
        }
        
        mergeSort(v,ans,0,n-1);
        
        return ans;
    }
}
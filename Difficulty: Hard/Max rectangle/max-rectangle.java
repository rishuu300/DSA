//{ Driver Code Starts
import java.util.*;

class FindMinCost {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().maxArea(arr));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    static int maxHist(int arr[], int n){
        Stack<Integer> s = new Stack<>();
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                int element = s.pop();
                int area = arr[element] * (s.isEmpty() ? i : (i-s.peek()-1));
                res = Math.max(res, area);
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int element = s.pop();
            int area = arr[element] * (s.isEmpty() ? n : (n-s.peek()-1));
            res = Math.max(res, area);
        }
        
        return res;
    }
    
    static int maxArea(int mat[][]) {
        int n = mat.length, m =  mat[0].length;
        int res = Integer.MIN_VALUE;
        int heights[] = new int[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(mat[i][j] == 1){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            
            int area = maxHist(heights, m);
            res = Math.max(res, area);
        }
        
        return res;
    }
}

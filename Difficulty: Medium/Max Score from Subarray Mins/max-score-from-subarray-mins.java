class Solution {
    public int maxSum(int arr[]) {
        int n = arr.length;
        int maxScore = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            
            int min1 = Math.min(a, b);
            int min2 = Math.max(a, b);
            
            maxScore = Math.max(maxScore, min1 + min2);
        }
        
        return maxScore;
    }
}
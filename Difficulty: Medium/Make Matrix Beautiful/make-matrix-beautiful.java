class Solution {
    public static int balanceSums(int[][] matrix) {
        int N = matrix.length;
        int maxSum = Integer.MIN_VALUE;
        int rowSum[] = new int[N];
        int colSum[] = new int[N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                rowSum[i] += matrix[i][j];
                maxSum = Math.max(maxSum, rowSum[i]);
                
                colSum[j] += matrix[i][j];
                maxSum = Math.max(maxSum, colSum[j]);
            }
        }
        
        int rowMax = 0;
        for(int i=0; i<N; i++){
            rowMax += (maxSum - rowSum[i]);
        }
        
        int colMax = 0;
        for(int i=0; i<N; i++){
            colMax += (maxSum - colSum[i]);
        }
        
        return Math.max(rowMax, colMax);
    }
}
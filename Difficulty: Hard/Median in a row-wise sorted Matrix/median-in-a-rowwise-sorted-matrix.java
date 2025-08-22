class Solution {
    static int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int min = Integer.MAX_VALUE, 
            max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
          
            if (mat[i][0] < min) 
              	min = mat[i][0];

            if (mat[i][m - 1] > max) 
              	max = mat[i][m - 1];
        }

        int desired = (n * m + 1) / 2;

        while (min < max) {
          
            int mid = min + (max - min) / 2;

            int place = 0;
            for (int i = 0; i < n; i++) {
                place += upperBound(mat[i], mid);
            }

            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    static int upperBound(int[] row, int num) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
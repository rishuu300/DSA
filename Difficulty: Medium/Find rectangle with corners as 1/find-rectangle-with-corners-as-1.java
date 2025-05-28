class Solution {
    public boolean ValidCorner(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        // Fix two columns at a time
        for (int c1 = 0; c1 < m - 1; c1++) {
            for (int c2 = c1 + 1; c2 < m; c2++) {
                int count = 0;
                for (int row = 0; row < n; row++) {
                    if (mat[row][c1] == 1 && mat[row][c2] == 1) {
                        count++;
                        if (count >= 2) return true; // Found rectangle
                    }
                }
            }
        }
        return false;
    }
}
class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(mat2[i][j]);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int complement = x - mat1[i][j];
                if (set.contains(complement)) {
                    count++;
                }
            }
        }

        return count;
    }
}
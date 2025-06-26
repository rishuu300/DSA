class Solution {
    public int getCount(int n) {
        int[][] moves = {
            {0, 8},
            {1, 2, 4},
            {2, 1, 3, 5},
            {3, 2, 6},
            {4, 1, 5, 7},
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},
            {7, 4, 8},
            {8, 5, 7, 9, 0},
            {9, 6, 8}
        };
        
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            int[] next = new int[10];
            for (int d = 0; d < 10; d++) {
                for (int move : moves[d]) {
                    next[d] += dp[move];
                }
            }
            dp = next;
        }
        
        int total = 0;
        for (int count : dp) {
            total += count;
        }
        return total;
    }
}
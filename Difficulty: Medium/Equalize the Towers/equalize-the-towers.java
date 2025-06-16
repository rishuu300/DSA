class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] towers = new int[n][2];

        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }

        Arrays.sort(towers, (a, b) -> Integer.compare(a[0], b[0]));

        long totalCost = 0;
        for (int[] tower : towers) {
            totalCost += tower[1];
        }

        long currCost = 0;
        int targetHeight = 0;
        for (int[] tower : towers) {
            currCost += tower[1];
            if (currCost >= (totalCost + 1) / 2) {
                targetHeight = tower[0];
                break;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += 1L * Math.abs(heights[i] - targetHeight) * cost[i];
        }

        return (int) result;
    }
}

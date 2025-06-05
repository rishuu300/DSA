class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] dp = new int[V];
        Arrays.fill(dp, -1);

        return dfs(src, dest, graph, dp);
    }

    private int dfs(int u, int dest, List<List<Integer>> graph, int[] dp) {
        if (u == dest) return 1;
        if (dp[u] != -1) return dp[u];

        int totalPaths = 0;
        for (int v : graph.get(u)) {
            totalPaths += dfs(v, dest, graph, dp);
        }

        dp[u] = totalPaths;
        return dp[u];
    }
}
class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean marked[],
                         int lowest[], int timeIn[], int timer[], int node, int parent){
                            
        visited[node] = true;
        timeIn[node] = timer[0];
        lowest[node] = timer[0];
        timer[0]++;
        
        int children = 0;
        
        for(int adjNode : adj.get(node)){
            if(adjNode == parent) continue;
            
            if(!visited[adjNode]){
                dfs(adj, visited, marked, lowest, timeIn, timer, adjNode, node);
                
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
                
                if(lowest[adjNode] >= timeIn[node] && parent != -1){
                    marked[node] = true;
                }
                
                children++;
            }
            else{
                lowest[node] = Math.min(lowest[node], timeIn[adjNode]);
            }
        }
        
        if(children > 1 && parent == -1){
            marked[node] = true;
        }
        
    }
    
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean marked[] = new boolean[V];
        int timeIn[] = new int[V];
        int lowest[] = new int[V];
        int timer[] = new int[]{1};
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(adj, visited, marked, lowest, timeIn, timer, i, -1);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(marked[i]){
                ans.add(i);
            }
        }
        
        return ans.size() == 0 ? new ArrayList<>(Arrays.asList(-1)) : ans;
    }
}
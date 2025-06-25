class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, 
                    boolean visited[], int node){
        visited[node] = true;
        
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(adj, st, visited, i);
            }
        }
        
        st.push(node);
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int node){
        visited[node] = true;
        
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(adj, visited, i);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(adj, stack, visited, i);
            }
        }
        
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            visited[i] = false;
            reversedAdj.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int j : adj.get(i)){
                reversedAdj.get(j).add(i);
            }
        }
        
        int count = 0;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]){
                dfs(reversedAdj, visited, curr);
                count++;
            }
        }
        
        return count;
    }
}
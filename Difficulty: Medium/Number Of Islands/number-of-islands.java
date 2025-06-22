// User function Template for Java

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if (ulp_u == ulp_v) return;
        
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } 
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } 
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}

class Solution {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds  = new DisjointSet(rows * cols);
        boolean visited[][] = new boolean[rows][cols];
        List<Integer> ans =  new ArrayList<>();
        
        int count = 0;
        for(int i=0; i<operators.length; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(visited[row][col]){
                ans.add(count);
                continue;
            }
            
            count++;
            visited[row][col] = true;
            
            int drow[] = {-1, 0, +1, 0};
            int dcol[] = {0, +1, 0, -1};
            
            for(int j=0; j<4; j++){
                int adjRow = row + drow[j];
                int adjCol = col + dcol[j];
                
                if(adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols){
                    if(visited[adjRow][adjCol]){
                        int node = (row * cols) + col;
                        int adjNode = (adjRow * cols) + adjCol;
                        
                        if(ds.findUPar(node) != ds.findUPar(adjNode)){
                            ds.unionByRank(node, adjNode);
                            count--;
                        }
                    }
                }
            }
            
            ans.add(count);
        }
        
        return ans;
    }
}

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if (ulp_u == ulp_v) return;
        
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } 
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    private  boolean isValid(int row, int col, int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        // Step 1
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 0) continue;
                
                int drow[] = {+1, 0, -1, 0};
                int dcol[] = {0, -1, 0, +1};
                
                for(int i=0; i<4; i++){
                    int newRow = row + drow[i];
                    int newCol = col + dcol[i];
                    
                    if(isValid(newRow, newCol, n) && grid[newRow][newCol] == 1){
                        int node = row * n + col;
                        int adjNode = newRow * n + newCol;
                        
                        if(ds.findUPar(node) != ds.findUPar(adjNode)){
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }
        
        
        // Step 2
        int max = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 1) continue;
                
                Set<Integer> components = new HashSet<>();
                int drow[] = {+1, 0, -1, 0};
                int dcol[] = {0, -1, 0, +1};
                
                for(int i=0; i<4; i++){
                    int newRow = row + drow[i];
                    int newCol = col + dcol[i];
                    
                    if(isValid(newRow, newCol, n)){
                        if(grid[newRow][newCol] == 1){
                            int adjNode = newRow * n + newCol;
                            
                            components.add(ds.findUPar(adjNode));
                        }
                    }
                }
                
                int total = 0;
                for(int component : components){
                    total += ds.size.get(component);
                }
                
                max = Math.max(max, total + 1);
            }
        }
        
        for(int cell=0; cell<(n*n); cell++){
            max = Math.max(max, ds.size.get(ds.findUPar(cell)));
        }
        
        return max;
    }
}
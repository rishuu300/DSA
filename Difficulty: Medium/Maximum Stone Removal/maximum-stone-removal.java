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
    int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;
        
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            
            ds.unionBySize(row, col);
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1);
        }
        
        int count = 0;
        for(Map.Entry<Integer, Integer> e : stoneNodes.entrySet()){
            if(ds.findUPar(e.getKey()) == e.getKey()){
                count++;
            }
        }
        
        return n - count;
    }
};
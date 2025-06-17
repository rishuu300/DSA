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
    public List<List<String>> mergeDetails(List<List<String>> details) {
        int n = details.size();
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        
        for(int i=0; i<n; i++){
            for(int j=1; j<details.get(i).size(); j++){
                String mail = details.get(i).get(j);
                
                if(map.containsKey(mail)){
                    int u = map.get(mail);
                    ds.unionByRank(u, i);
                }
                else{
                    map.put(mail, i);
                }
            }
        }
        
        ArrayList<String> mergedMails[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedMails[i] = new ArrayList<>();
        }
        
        for(Map.Entry<String, Integer> e : map.entrySet()){
            String mail = e.getKey();
            int node = ds.findUPar(e.getValue());
            
            mergedMails[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(mergedMails[i].size() == 0)continue;
            
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            
            Collections.sort(mergedMails[i]);
            
            for(String it : mergedMails[i]){
                temp.add(it);
            }
            
            ans.add(temp);
        }
        
        return ans;
    }
}
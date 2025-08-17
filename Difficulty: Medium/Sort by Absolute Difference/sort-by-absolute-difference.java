class Solution {
    public void rearrange(int[] arr, int x) {
        int n = arr.length;
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(x - arr[i]);
            if (m.containsKey(diff)) {
                ArrayList<Integer> al = m.get(diff);
                al.add(arr[i]);
                m.put(diff, al);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                m.put(diff, al);
            }
        }
        
        int index = 0;
        for (Map.Entry entry : m.entrySet()) {
            ArrayList<Integer> al = m.get(entry.getKey());
            for (int i = 0; i < al.size(); i++)
                arr[index++] = al.get(i);
        }
    }
}

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;
        
        k = k % n;
        if (k == 0) return;
        
        List<Integer> list = new ArrayList<>(dq);
        dq.clear();
        
        if (type == 1) { 
            dq.addAll(list.subList(n - k, n));
            dq.addAll(list.subList(0, n - k));
        } else {
            dq.addAll(list.subList(k, n));
            dq.addAll(list.subList(0, k));
        }
    }
}
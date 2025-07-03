class Solution {
    public int countAtMostK(int arr[], int k) {
        int start = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int end = 0; end < arr.length; end++) {
            int endNum = arr[end];
            freq.put(endNum, freq.getOrDefault(endNum, 0) + 1);
            
            while (freq.size() > k) {
                int startNum = arr[start];
                freq.put(startNum, freq.get(startNum) - 1);
                
                if (freq.get(startNum) == 0) {
                    freq.remove(startNum);
                }
                
                start++;
            }
            
            res += end - start + 1;
        }
        
        return res;
    }
}
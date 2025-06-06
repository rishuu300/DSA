
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
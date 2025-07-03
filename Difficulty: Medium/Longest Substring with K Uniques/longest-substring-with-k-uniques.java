class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = -1;

        for (int end = 0; end < n; end++) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            while (map.size() > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }
}
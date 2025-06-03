// User function Template for Java

class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        if (k == 0) return 0;

        int[] freq = new int[26];
        int left = 0, right = 0, count = 0, distinct = 0;

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinct++;
            }
            freq[s.charAt(right) - 'a']++;

            while (distinct > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
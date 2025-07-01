class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;

        int[] freq = new int[26];
        int distinct = 0, count = 0;

        for (int i = 0; i < k; i++) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] == 0) distinct++;
            freq[idx]++;
        }
        if (distinct == k - 1) count++;

        for (int i = k; i < s.length(); i++) {
            int outChar = s.charAt(i - k) - 'a';
            int inChar = s.charAt(i) - 'a';

            freq[outChar]--;
            if (freq[outChar] == 0) distinct--;

            if (freq[inChar] == 0) distinct++;
            freq[inChar]++;

            if (distinct == k - 1) count++;
        }

        return count;
    }
}
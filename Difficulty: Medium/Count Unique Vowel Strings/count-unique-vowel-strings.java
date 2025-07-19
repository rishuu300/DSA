class Solution {
    public int vowelCount(String s) {
        int[] freq = new int[26];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                freq[ch - 'a']++;
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (char v : vowels) {
            if (freq[v - 'a'] > 0) {
                counts.add(freq[v - 'a']);
            }
        }

        int k = counts.size();
        if (k == 0) return 0;

        int total = 1;
        for (int c : counts) total *= c;

        total *= factorial(k);
        return total;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
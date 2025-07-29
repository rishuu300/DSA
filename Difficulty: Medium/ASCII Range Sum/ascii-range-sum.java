class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1)
                first[idx] = i;
            last[idx] = i;
        }

        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] != -1 && last[ch] != first[ch]) {
                int sum = 0;
                for (int i = first[ch] + 1; i < last[ch]; i++) {
                    sum += s.charAt(i);
                }
                if (sum != 0)
                    res.add(sum);
            }
        }

        return res;
    }
}
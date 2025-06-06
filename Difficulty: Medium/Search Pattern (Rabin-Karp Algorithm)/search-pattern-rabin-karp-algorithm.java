class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();
        if (m > n) return result;

        int base = 26;
        int mod = 1000000007;

        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        long patHash = 0, txtHash = 0;

        for (int i = 0; i < m; i++) {
            patHash = (patHash * base + pat.charAt(i)) % mod;
            txtHash = (txtHash * base + txt.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patHash == txtHash) {
                if (txt.substring(i, i + m).equals(pat)) {
                    result.add(i + 1);
                }
            }

            if (i < n - m) {
                txtHash = (txtHash - txt.charAt(i) * power % mod + mod) % mod;
                txtHash = (txtHash * base + txt.charAt(i + m)) % mod;
            }
        }

        return result;
    }
}
class Solution {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int countBalanced(String[] arr) {
        int n = arr.length;
        int res = 0;
        int prefix = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        for (int i = 0; i < n; i++) {
            int score = 0;

            for (char ch : arr[i].toCharArray()) {
                if (isVowel(ch)) score++;
                else score--;
            }

            prefix += score;

            res += freq.getOrDefault(prefix, 0);

            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}
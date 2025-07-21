class Solution {
    int cntCoprime(int[] arr) {
        int M = 10000;
        int n = arr.length;
        
        int[] freq = new int[M + 1];
        for (int x : arr) {
            freq[x]++;
        }

        int[] cnt = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = i; j <= M; j += i) {
                cnt[i] += freq[j];
            }
        }

        int[] mobius = new int[M + 1];
        for (int i = 0; i <= M; i++) mobius[i] = 1;

        boolean[] isPrime = new boolean[M + 1];
        for (int i = 2; i <= M; i++) {
            if (!isPrime[i]) {
                for (int j = i; j <= M; j += i) {
                    isPrime[j] = true;
                    mobius[j] *= -1;
                }
                long sq = (long) i * i;
                if (sq <= M) {
                    for (int j = (int) sq; j <= M; j += sq) {
                        mobius[j] = 0;
                    }
                }
            }
        }

        long ans = 0;
        for (int d = 1; d <= M; d++) {
            if (cnt[d] >= 2 && mobius[d] != 0) {
                long pairs = (long) cnt[d] * (cnt[d] - 1) / 2;
                ans += mobius[d] * pairs;
            }
        }

        return (int) ans;
    }
}
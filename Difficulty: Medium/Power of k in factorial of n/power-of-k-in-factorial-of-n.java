class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        
        if (k > 1) {
            primeFactors.put(k, 1);
        }
        
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int p = entry.getKey();
            int countInK = entry.getValue();
            int countInFact = 0;
            long temp = p;
            while (temp <= n) {
                countInFact += n / temp;
                temp *= p;
            }
            result = Math.min(result, countInFact / countInK);
        }
        
        return result;
    }
}
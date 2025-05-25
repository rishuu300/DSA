class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int max = 1000;
        boolean[] freq = new boolean[max * max + 1];
        
        for (int num : arr) {
            freq[num * num] = true;
        }
        
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                int sumSq = i * i + j * j;
                if (sumSq <= max * max && freq[i * i] && freq[j * j] && freq[sumSq]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
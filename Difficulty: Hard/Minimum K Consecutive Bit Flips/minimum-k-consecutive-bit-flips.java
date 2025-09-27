class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flipCount = 0;
        int currFlips = 0;  
        int[] isFlipped = new int[n]; 

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                currFlips -= isFlipped[i - k];
            }

            int actual = (currFlips % 2 == 0) ? arr[i] : 1 - arr[i];

            if (actual == 0) {
                if (i + k > n) return -1;
                isFlipped[i] = 1;
                currFlips++;
                flipCount++;
            }
        }
        return flipCount;
    }
}
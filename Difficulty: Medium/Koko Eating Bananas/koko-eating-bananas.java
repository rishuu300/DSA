class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;
        
        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            int hours = 0;

            for (int bananas : arr) {
                hours += (bananas + mid - 1) / mid;
            }

            if (hours <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

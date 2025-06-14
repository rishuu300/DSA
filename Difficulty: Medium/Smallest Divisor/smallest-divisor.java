class Solution {
    public int smallestDivisor(int[] arr, int k) {
        int left = 1, right = getMax(arr);
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = computeSum(arr, mid);

            if (sum <= k) {
                ans = mid; 
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }

        return ans;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    private int computeSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}
class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSplit(int[] arr, int k, int maxAllowedSum) {
        int currentSum = 0, splits = 1;

        for (int num : arr) {
            if (currentSum + num > maxAllowedSum) {
                splits++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return splits <= k;
    }
};
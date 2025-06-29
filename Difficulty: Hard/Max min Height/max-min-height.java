class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] water = new int[n + 1];
        int ops = 0;
        int added = 0;

        for (int i = 0; i < n; i++) {
            added += water[i];
            int currentHeight = arr[i] + added;

            if (currentHeight < target) {
                int need = target - currentHeight;
                ops += need;
                if (ops > k) return false;

                added += need;
                if (i + w < n)
                    water[i + w] -= need;
            }
        }
        return true;
    }
}
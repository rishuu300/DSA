class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        int[] res = new int[k];

        int right = binarySearch(arr, x);
        int left = right - 1;
        int i = 0;

        while (i < k) {
            if (left >= 0 && (right >= n || closer(arr[left], arr[right], x))) {
                if (arr[left] != x) res[i++] = arr[left];
                left--;
            } else {
                if (right < n && arr[right] != x) res[i++] = arr[right];
                right++;
            }
        }

        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private boolean closer(int a, int b, int x) {
        int diffA = Math.abs(a - x), diffB = Math.abs(b - x);
        if (diffA != diffB) return diffA < diffB;
        return a > b;
    }
}

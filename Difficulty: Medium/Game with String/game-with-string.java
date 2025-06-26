class Solution {
    public int minValue(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            top--;
            if (top > 0) pq.offer(top);
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            result += val * val;
        }

        return result;
    }
}
class Solution {
    public int findLength(int[] color, int[] radius) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < color.length; i++) {
            int[] curr = new int[]{color[i], radius[i]};

            if (!stack.isEmpty() && stack.peek()[0] == curr[0] && stack.peek()[1] == curr[1]) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return stack.size();
    }
}
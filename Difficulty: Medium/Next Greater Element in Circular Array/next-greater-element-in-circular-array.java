class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[idx]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.set(idx, arr[stack.peek()]);
            }
            stack.push(idx);
        }
        return res;
    }
}
class Solution {
    int index = 0;
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> leafNodes(int[] preorder) {
        index = 0;
        res.clear();
        findLeaves(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }

    private boolean findLeaves(int[] preorder, int n, int min, int max) {
        if (index >= n || preorder[index] < min || preorder[index] > max)
            return false;

        int val = preorder[index++];
        boolean left = findLeaves(preorder, n, min, val - 1);
        boolean right = findLeaves(preorder, n, val + 1, max);

        // If both left and right are false, current node is a leaf
        if (!left && !right)
            res.add(val);

        return true;
    }
}
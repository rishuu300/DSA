class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        int max = 100000;
        int[] count = new int[max + 1];
        
        for (int num : b) {
            count[num]++;
        }
        
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : a) {
            res.add(count[num]);
        }
        
        return res;
    }
}
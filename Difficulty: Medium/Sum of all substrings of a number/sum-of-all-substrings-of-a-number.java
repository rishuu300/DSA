class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long totalSum = 0;
        long prevSum = 0;
        
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            long currSum = prevSum * 10 + d * (i + 1);
            totalSum += currSum;
            prevSum = currSum;
        }
        
        return (int) totalSum;
    }
}
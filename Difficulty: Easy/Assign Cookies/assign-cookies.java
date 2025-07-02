
class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        int n = greed.length;
        int m = cookie.length;
        
        Arrays.sort(greed);
        Arrays.sort(cookie);
        
        int left = 0;
        int right = 0;
        int count = 0;
        
        while(left < n && right < m){
            if(greed[left] <= cookie[right]){
                count++;
                right++;
                left++;
            }
            else{
                right++;
            }
        }
        
        return count;
    }
}
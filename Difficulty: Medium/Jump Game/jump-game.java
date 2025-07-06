// User function Template for Java

class Solution {
    public boolean canReach(int[] arr) {
        int maxJumps = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i > maxJumps){
                return false;
            }
            
            maxJumps = Math.max(maxJumps, i + arr[i]);
        }
        
        return true;
    }
}
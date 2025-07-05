// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        
        Arrays.sort(bt);
        
        int waitingTime = 0;
        int time = 0;
        
        for(int i=0; i<n; i++){
            waitingTime += time;
            time += bt[i];
        }
        
        return waitingTime/n;
    }
}

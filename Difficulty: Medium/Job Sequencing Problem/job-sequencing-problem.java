class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2];
        
        for(int i = 0; i<n; i++){
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }
        

        Arrays.sort(jobs, (a,b) -> b[0] - a[0]);
        
        int max = Arrays.stream(deadline).max().getAsInt();
        boolean[] slots = new boolean[max+1];
        int pr = 0;
        int dl = 0;
        
        int count = 0;
        int total = 0;
        
        for(int i = 0; i<n; i++){
            pr = jobs[i][0];
            dl = jobs[i][1];
            
            for(int j = dl; j >= 1; j--){
                if(slots[j] == false){
                    slots[j] = true;
                    count++;
                    total += pr;
                    break;
                }
            }
        }
        
        return new ArrayList<>(Arrays.asList(count, total));
    }
}
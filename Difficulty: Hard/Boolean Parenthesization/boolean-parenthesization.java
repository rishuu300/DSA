//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int rec(String str, int i, int j, int isTrue){
        if(i==j){
            if(isTrue==1){
                return (str.charAt(i) == 'T') ? 1 : 0;
            }
            else return (str.charAt(i) == 'F') ? 1 : 0;
        }
        
        int ways = 0;
        for(int idx=i+1; idx<=j-1; idx+=2){
            int lT = rec(str,i,idx-1,1);
            int lF = rec(str,i,idx-1,0);
            int rT = rec(str,idx+1,j,1);
            int rF = rec(str,idx+1,j,0);
            
            if(str.charAt(idx) == '&'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT));
                }
                else{
                    ways = (ways + ((lT * rF) + (lF * rT) + (lF * rF)));
                }
            }
            else if(str.charAt(idx) == '|'){
                if(isTrue == 1){
                    ways = (ways + ((lT * rF) + (lF * rT) + (lT * rT)));
                }
                else{
                    ways = (ways + (lF * rF));
                }
            }
            else{
                if(isTrue == 1){
                    ways = (ways + ((lT * rF) + (lF * rT)));
                }
                else{
                    ways = (ways + ((lT * rT) + (lF * rF)));
                }
            }
        }
        
        return ways;
    }
    
    static int memo(String str, int i, int j, int isTrue, int[][][] memo){
        if(i==j){
            if(isTrue==1){
                return (str.charAt(i) == 'T') ? 1 : 0;
            }
            else return (str.charAt(i) == 'F') ? 1 : 0;
        }
        
        if(memo[i][j][isTrue] != -1){
            return memo[i][j][isTrue];
        }
        
        int ways = 0;
        for(int idx=i+1; idx<=j-1; idx+=2){
            int lT = memo(str,i,idx-1,1,memo);
            int lF = memo(str,i,idx-1,0,memo);
            int rT = memo(str,idx+1,j,1,memo);
            int rF = memo(str,idx+1,j,0,memo);
            
            if(str.charAt(idx) == '&'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT));
                }
                else{
                    ways = (ways + ((lT * rF) + (lF * rT) + (lF * rF)));
                }
            }
            else if(str.charAt(idx) == '|'){
                if(isTrue == 1){
                    ways = (ways + ((lT * rF) + (lF * rT) + (lT * rT)));
                }
                else{
                    ways = (ways + (lF * rF));
                }
            }
            else{
                if(isTrue == 1){
                    ways = (ways + ((lT * rF) + (lF * rT)));
                }
                else{
                    ways = (ways + ((lT * rT) + (lF * rF)));
                }
            }
        }
        
        return memo[i][j][isTrue] = ways;
    }
    
    static int countWays(String s) {
        int n = s.length();
        int[][][] memo = new int[n][n][2];
        for(int i[][] : memo){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return memo(s,0,s.length()-1,1,memo);
    }
}
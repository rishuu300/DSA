//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new Solution().modified(a));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




class Solution {
    public static long modified(String a) {
        long count = 1, ans = 0;
        char prev = a.charAt(0);
        
        for(int i=1; i<a.length(); i++){
            if(a.charAt(i) == prev){
                count++;
            }
            else{
                prev = a.charAt(i);
                count = 1;
            }
            
            if(count == 3){
                ans++;
                count = 1;
            }
        }
        
        if(count == 3){
            ans++;
        }
        
        return ans;
    }
}
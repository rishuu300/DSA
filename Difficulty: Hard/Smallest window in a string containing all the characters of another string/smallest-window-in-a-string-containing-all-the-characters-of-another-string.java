//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        while (test > 0) {
            String s1 = scan.next();
            String s2 = scan.next();

            System.out.println(new Solution().smallestWindow(s1, s2));
            test--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static String smallestWindow(String s1, String s2) {
        if(s1.equals(s2)){
            return s1;
        }
        
        if(s2.length() > s1.length()){
            return "-1";
        }
        
        HashMap<Character, Integer> Pmap = new HashMap<>();
        for(int i=0; i<s2.length(); i++){
            Pmap.put(s2.charAt(i), Pmap.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        HashMap<Character, Integer> Smap = new HashMap<>();
        int left = 0, right = 0, result_length = Integer.MAX_VALUE;
        int currlen = 0, total_length = Pmap.size();
        String result = "-1";
        
        while(right < s1.length()){
            char ch = s1.charAt(right);
            Smap.put(ch, Smap.getOrDefault(ch, 0) + 1);
            
            if(Pmap.containsKey(ch) && Pmap.get(ch) == Smap.get(ch)){
                currlen++;
            }
            
            while(currlen == total_length){
                if(right - left + 1 < result_length){
                    result_length = right - left + 1;
                    result = s1.substring(left, right+1);
                }
                
                char left_char = s1.charAt(left);
                Smap.put(left_char, Smap.get(left_char) - 1);
                
                if(Pmap.containsKey(left_char) && Smap.get(left_char) < Pmap.get(left_char)){
                    currlen--;
                }
                
                left++;
            }
            right++;
        }
        
        return (result_length != Integer.MAX_VALUE) ? result : "-1";
    }
}
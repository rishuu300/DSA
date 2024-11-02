//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            Solution obj = new Solution();
            
            System.out.println(obj.concatenatedString(s1,s2));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution
{
    //Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1,String s2)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s2.length(); i++){
            map.put(s2.charAt(i), 1);
        }
        
        String str = "";
        for(int i=0; i<s1.length(); i++){
            if(!map.containsKey(s1.charAt(i))){
                str += s1.charAt(i);
            }
            else{
                map.put(s1.charAt(i), 2);
            }
        }
        
        for(int i=0; i<s2.length(); i++){
            if(map.get(s2.charAt(i)) == 1){
                str += s2.charAt(i);
            }
        }
        
        return (str.length() == 0) ? "-1" : str;
    }
}

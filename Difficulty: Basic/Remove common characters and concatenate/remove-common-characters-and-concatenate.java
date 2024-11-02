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
        String str = "";
        
        for(char ch : s1.toCharArray()){
            if(s2.indexOf(ch) == -1){
                str += ch;
            }
        }
        
        for(char ch : s2.toCharArray()){
            if(s1.indexOf(ch) == -1){
                str += ch;
            }
        }
        
        return (str.length() == 0) ? "-1" : str;
    }
}

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        HashSet<Character> s = new HashSet<>();
        for(int i=0; i<patt.length(); i++){
            s.add(patt.charAt(i));
        }
        
        for(int i=0; i<str.length(); i++){
            if(s.contains(str.charAt(i))){
                return i;
            }
        }
        
        return -1;
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		
System.out.println("~");
}
	}
}

// } Driver Code Ends
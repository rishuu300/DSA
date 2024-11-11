//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static String caseSort(String str) {
        int n = str.length();
        char UC[] = new char[26];
        char LC[] = new char[26];
        
        for(int i=0; i<n; i++){
            char ch  = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                LC[ch - 'a']++;
            }
            else{
                UC[ch - 'A']++;
            }
        }
        
        StringBuilder res = new StringBuilder();
        int li = 0, ui = 0;
        
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                while(li < 26 && LC[li] == 0){
                    li++;
                }
                
                if(li < 26){
                    res.append((char) (li + 'a'));
                    LC[li]--;
                }
            }
            else{
                while(ui < 26 && UC[ui] == 0){
                    ui++;
                }
                
                if(ui < 26){
                    res.append((char) (ui + 'A'));
                    UC[ui]--;
                }
            }
        }
        
        return res.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    
out.println("~");
}
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends
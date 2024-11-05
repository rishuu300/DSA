//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Rearrange
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            
            int old = str.length();
            int chs[] = new int[26];
            Arrays.fill(chs, 0);
            
            for(int i=0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
                chs[idx]++;
            }
            Solution gfg = new Solution();     
            str = gfg.rearrangeString(str);
            int flag=1,ff=0;
            int chs2[] = new int[26];
            Arrays.fill(chs2, 0);
	        
	        for(int i=0;i<str.length();i++){
	            int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
	            chs2[idx]++;
	        }
	             
	        if(str.length() != old)
	         System.out.println(0);
	        else
	        {
	            
    	        for(int i=0;i<26;i++)
                    if(chs[i] != chs2[i])
                        ff=1;
                
                if(ff==1){
                        System.out.println(0);
                }
                else{
        	        if(str != "-1"){
                    	for(int i=1;i<str.length();i++)
                    	{
                    		if(str.charAt(i-1) == str.charAt(i))
                    			flag=0;
                    	}
                    	if(flag == 1)
                    		System.out.println(1);
                    	else
                    	System.out.println(0 );
                    }
    	            else
    	            	System.out.println(0);
                }
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/* The below function should return 
the transformed string */
class Solution {
    public static char maxChar(char char_count[]){
        int count = 0;
        char maxChar = '\0';
        
        for(int i=0; i<26; i++){
            if(char_count[i] > count){
                count = char_count[i];
                maxChar = (char)(i + 'a');
            }
        }
        
        return maxChar;
    }
    
    public static String rearrangeString(String str) {
        char char_count[] = new char[26];
        int n = str.length();
        
        if(n==1){
            return str;
        }
        
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            char_count[ch - 'a']++;
        }
        
        char maxChar = maxChar(char_count);
        int count = char_count[maxChar - 'a'];
        
        if(count > (n + 1)/ 2){
            return "0";
        }
        
        StringBuilder res = new StringBuilder(" ".repeat(n));
        int idx = 0;
        
        while(count > 0){
            res.setCharAt(idx, maxChar);
            idx += 2;
            count--;
        }
        char_count[maxChar - 'a'] = 0;
        
        for(int i=0; i<26; i++){
            while(char_count[i] > 0){
                if(idx >= n){
                    idx = 1;
                }
                
                res.setCharAt(idx, (char)(i + 'a'));
                idx += 2;
                char_count[i]--;
            }
        }
        
        return res.toString();
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair {
    String word;
    int steps;
    
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int N = wordList.length;
        
        for(int i=0; i<N; i++){
            set.add(wordList[i]);
        }
        
        q.add(new Pair(startWord, 1));
        set.remove(startWord);
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;
            
            if(word.equals(targetWord)){
                return steps;
            }
            
            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char chars[] = word.toCharArray();
                    chars[i] = ch;
                    
                    String newWord = new String(chars);//chars.toString() returns the object's memory address string — something like "[C@4eec7777" — because arrays in Java inherit Object.toString(), which gives class name + hash code.
                    
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}
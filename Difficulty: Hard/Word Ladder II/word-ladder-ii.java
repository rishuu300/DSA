//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
                                                        
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(startWord)));
        set.remove(startWord);
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            
            for(int i=0; i<size; i++){
                ArrayList<String> list = q.poll();
                
                String word = list.get(list.size()-1);
                set.remove(word);
                
                if(word.equals(targetWord)){
                    result.add(new ArrayList<>(list));
                    found = true;
                    continue;
                }
                
                for(int j=0; j<word.length(); j++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char chars[] = word.toCharArray();
                        
                        chars[j] = ch;
                        
                        String newWord = new String(chars);
                        
                        if(set.contains(newWord)){
                            ArrayList<String> newList = new ArrayList<>(list);
                            newList.add(newWord);                          
                            q.add(newList);
                        }
                    }
                }
            }
            
            if(found){
                return result;
            }
        }
        
        return result;
    }
}
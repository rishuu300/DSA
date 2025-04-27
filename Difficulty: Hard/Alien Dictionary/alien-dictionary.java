//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    String topoSort(List<List<Integer>> adj, int V, Set<Character> set){
        int inDegree[] = new int[V];
        
        for(int i=0; i<V; i++){
            for(int j : adj.get(i)){
                inDegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (char ch : set){
            if (inDegree[ch - 'a'] == 0) {
                q.add(ch - 'a');
            }
        }
        
        String result = "";
        
        while(!q.isEmpty()){
            int curr = q.poll();
            result += (char)(curr + 'a');
            
            for(int j : adj.get(curr)){
                inDegree[j]--;
                
                if(inDegree[j] == 0){
                  q.add(j);
                }
            }
        }
        
        if (result.length() < set.size()){
            return "";
        }
        
        return result;
    }
    
    public String findOrder(String[] words) {
        Set<Character> set = new HashSet<>();
        for(String word : words){
            for(char ch : word.toCharArray()){
                set.add(ch);
            }
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            
            boolean foundDifference = false;
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    foundDifference = true;
                    break;
                }
            }
            
            if (!foundDifference && s1.length() > s2.length()) {
                return "";
            }
        }
        
        return topoSort(adj, 26, set);
    }
}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends
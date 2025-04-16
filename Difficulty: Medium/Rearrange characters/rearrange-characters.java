//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String str = br.readLine();
                Solution ob = new Solution();
                String str1 = ob.rearrangeString(str);

                int flag = 1;
                int[] c = new int[26];
                Arrays.fill(c, 0);
                for (int i = 0; i < str.length(); i++) c[str.charAt(i) - 'a'] += 1;
                int f = 0;
                int x = (str.length() + 1) / 2;
                for (int i = 0; i < 26; i++) {
                    if (c[i] > x) f = 1;
                }
                if (f == 1) {
                    if (str1 == "")
                        System.out.println(0);
                    else
                        System.out.println(1);
                } else {
                    int[] a = new int[26];
                    Arrays.fill(a, 0);
                    int[] b = new int[26];
                    Arrays.fill(b, 0);
                    for (int i = 0; i < str.length(); i++) a[str.charAt(i) - 'a'] += 1;
                    for (int i = 0; i < str1.length(); i++)
                        b[str1.charAt(i) - 'a'] += 1;

                    for (int i = 0; i < 26; i++)
                        if (a[i] != b[i]) flag = 0;

                    for (int i = 0; i < str1.length(); i++) {
                        if (i > 0)
                            if (str1.charAt(i - 1) == str1.charAt(i)) flag = 0;
                    }
                    if (flag == 1)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }

                System.out.println("~");
            }
        } catch (Exception e) {
        }
    }
}
// } Driver Code Ends

class Info {
    char ch;
    int freq;
    
    Info(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public static String rearrangeString(String str) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.add(new Info(e.getKey(), e.getValue()));
        }
        
        StringBuilder res = new StringBuilder();
        Info prev = null;
        
        while(!pq.isEmpty()){
            Info curr = pq.poll();
            
            res.append(curr.ch);
            
            if(prev != null && prev.freq > 0){
                pq.add(prev);
            }
            
            curr.freq--;
            prev = curr;
        }
        
        return (res.length() == str.length()) ? res.toString() : "";
        
    }
}
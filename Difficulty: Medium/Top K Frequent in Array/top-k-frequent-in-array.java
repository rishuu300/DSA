//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Info {
    int data; 
    int freq;
    
    Info(int data, int freq){
        this.data = data;
        this.freq = freq;
    }
}

class Solution {
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq) ? (a.data - b.data) : (a.freq - b.freq));
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            pq.add(new Info(e.getKey(), e.getValue()));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            result.add(0, pq.poll().data);
        }
        
        return result;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().topKFrequent(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
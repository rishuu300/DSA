//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Node {
        int val, row, idx;
        Node(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        int max = Integer.MIN_VALUE;
        // Initialize heap with first elements of each list
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;

        while (pq.size() == k) {
            Node curr = pq.poll();
            int min = curr.val;

            if (max - min < range) {
                range = max - min;
                start = min;
                end = max;
            }

            // Move to next element in the same row
            if (curr.idx + 1 < n) {
                int nextVal = arr[curr.row][curr.idx + 1];
                pq.offer(new Node(nextVal, curr.row, curr.idx + 1));
                max = Math.max(max, nextVal);
            } else {
                break; // One list is exhausted
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
    }
}
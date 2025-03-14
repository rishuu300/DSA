//{ Driver Code Starts
// Initial Template for Java

// Contributed by Sudarshan Sharma
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.verticalOrder(root);
            System.out.print("[ ");
            for (ArrayList<Integer> vec : res) {
                System.out.print("[ ");
                for (int val : vec) {
                    System.out.print(val + " ");
                }
                System.out.print("] ");
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    // Helper function to perform DFS and
    // store nodes at different horizontal distances
    static void DFS(Node root, int hd, int[] mn,
                    HashMap<Integer, ArrayList<Integer>> mp) {
        if (root == null) return;

        // Store the current node in the map at horizontal distance hd
        if (!mp.containsKey(hd)) mp.put(hd, new ArrayList<>());

        mp.get(hd).add(root.data);

        // Update the minimum horizontal distance
        mn[0] = Math.min(mn[0], hd);

        // Recursively traverse the left and right subtrees
        DFS(root.left, hd - 1, mn, mp);
        DFS(root.right, hd + 1, mn, mp);
    }

    // Function to perform vertical order traversal of a binary tree
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        // HashMap to store nodes at each horizontal distance
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // Array to track the minimum horizontal distance (mutable)
        int[] mn = {0};

        // Perform DFS to fill the hashmap with vertical levels
        DFS(root, 0, mn, mp);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int hd = mn[0];

        // Traverse the map from minimum to maximum horizontal distance
        while (mp.containsKey(hd)) {
            res.add(mp.get(hd));
            hd++;
        }

        return res;
    }
}

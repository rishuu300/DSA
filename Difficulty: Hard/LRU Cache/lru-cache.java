//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value){
        this.key = key; 
        this.value = value;
        next = prev = null;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> map;
    
    LRUCache(int cap) {
        this.capacity = cap;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            add(curr);
            return curr.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
        }
        
        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
        
        if(map.size() > capacity){
            Node curr = tail.prev;
            map.remove(curr.key);
            remove(curr);
        }
    }
    
    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void add(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
}

//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    private Stack<Long> stack;
    private long min;

    public Solution() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push((long) x);
        } else {
            if (x < min) {
                stack.push(2L * x - min);
                min = x;
            } else {
                stack.push((long) x);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            long top = stack.pop();
            if (top < min) {
                min = 2 * min - top;
            }
        }
    }

    public int peek() {
        if (stack.isEmpty()) return -1;
        long top = stack.peek();
        return (top < min) ? (int) min : (int) top;
    }

    public int getMin() {
        return stack.isEmpty() ? -1 : (int) min;
    }
}
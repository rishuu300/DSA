//{ Driver Code Starts
import java.util.*;

class TwoStack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            twoStacks g = new twoStacks();
            int Q = sc.nextInt();
            while (Q > 0) {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                if (QueryType == 1) {
                    int a = sc.nextInt();
                    if (stack_no == 1)
                        g.push1(a);
                    else if (stack_no == 2)
                        g.push2(a);
                } else if (QueryType == 2) {
                    if (stack_no == 1)
                        System.out.print(g.pop1() + " ");
                    else if (stack_no == 2)
                        System.out.print(g.pop2() + " ");
                }

                Q--;
            }
            System.out.println();
            T--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class twoStacks {
    int top1;
    int top2;
    int arr[];
    
    twoStacks() {
        arr = new int[100];
        top1 = -1; top2 = 100;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if(top1 < top2-1){
            top1++;
            arr[top1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(top1 < top2-1){
            top2--;
            arr[top2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1 >= 0){
            int x = arr[top1--];
            return x;
        }
        return -1;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2 < 100){
            int x = arr[top2++];
            return x;
        }
        return -1;
    }
}

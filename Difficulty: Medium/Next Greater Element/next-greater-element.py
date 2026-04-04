class Solution:
    def nextLargerElement(self, arr):
        n = len(arr)
        stack = []
        nexts = [0] * n
        
        stack.append(n-1)
        nexts[n-1] = -1
        
        for i in range(n-2, -1, -1):
            while stack and arr[i] >= arr[stack[-1]]:
                stack.pop()
            
            nexts[i] = arr[stack[-1]] if stack else -1
            
            stack.append(i)
        
        return nexts
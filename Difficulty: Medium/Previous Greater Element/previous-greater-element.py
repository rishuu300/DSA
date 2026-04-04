class Solution:
    def preGreaterEle(self, arr):
        n = len(arr)
        stack = []
        prevs = [-1] * n
        
        stack.append(0)
        
        for i in range(1, n):
            while stack and arr[i] >= arr[stack[-1]]:
                stack.pop()
            
            if stack:
                prevs[i] = arr[stack[-1]]
            
            stack.append(i)
        
        return prevs